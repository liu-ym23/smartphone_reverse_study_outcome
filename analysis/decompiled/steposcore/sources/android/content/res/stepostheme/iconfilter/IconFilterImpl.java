package android.content.res.stepostheme.iconfilter;

import android.content.res.stepostheme.IStepOSIconFilterExt;
import android.content.res.stepostheme.StepOSLogUtil;
import android.content.res.stepostheme.iconfilter.bean.FilterConfigInfo;
import android.content.res.stepostheme.iconfilter.filters.BaseFilter;
import android.content.res.stepostheme.iconfilter.filters.ColorGradientFilter;
import android.content.res.stepostheme.iconfilter.filters.HueSaturationBrightnessFilter;
import android.graphics.Bitmap;
import com.android.internal.policy.StepOSSystemBarController;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class IconFilterImpl implements IStepOSIconFilterExt {
    private static final String TAG = "IconFilterImpl";
    private FilterConfigInfo mFilterConfig;
    private boolean isLoaded = false;
    private List<BaseFilter> mFilters = new ArrayList();

    public Bitmap filter(Bitmap bitmap) {
        if (!this.isLoaded || bitmap == null || this.mFilters.isEmpty()) {
            return bitmap;
        }
        Bitmap result = bitmap;
        for (BaseFilter filter : this.mFilters) {
            try {
                Bitmap filtered = filter.filter(result);
                if (filtered != null && filtered != result && result != bitmap) {
                    result.recycle();
                }
                if (filtered != null) {
                    result = filtered;
                }
            } catch (Exception e) {
                StepOSLogUtil.e("Filter error: " + e.getMessage());
            }
        }
        return result;
    }

    public void setConfig(InputStream is) {
        if (is == null) {
            return;
        }
        try {
            this.mFilterConfig = parseFilterConfig(is);
            if (this.mFilterConfig != null) {
                buildFilters(this.mFilterConfig);
                this.isLoaded = true;
            }
        } catch (Exception e) {
            StepOSLogUtil.e("Failed to parse filter config: " + e.getMessage());
            this.isLoaded = false;
        }
    }

    private FilterConfigInfo parseFilterConfig(InputStream is) throws ParserConfigurationException, SAXException, IOException {
        FilterConfigInfo config = new FilterConfigInfo();
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader reader = sp.getXMLReader();
            reader.setContentHandler(new FilterConfigHandler(config));
            reader.parse(new InputSource(is));
            return config;
        } catch (Exception e) {
            StepOSLogUtil.e("XML parse error: " + e.getMessage());
            return null;
        }
    }

    private void buildFilters(FilterConfigInfo config) {
        this.mFilters.clear();
        List<FilterConfigInfo.Filter> filters = config.getFilters();
        if (filters == null) {
            return;
        }
        for (FilterConfigInfo.Filter filterDef : filters) {
            BaseFilter filter = createFilter(filterDef);
            if (filter != null) {
                this.mFilters.add(filter);
            }
        }
    }

    private BaseFilter createFilter(FilterConfigInfo.Filter filterDef) {
        String name = filterDef.getName();
        Map<String, String> params = filterDef.getParams();
        if (FilterConfigInfo.Filter.FILTER_GRADIENT_MAPPING.equals(name)) {
            ColorGradientFilter filter = new ColorGradientFilter();
            String startColor = params.get(FilterConfigInfo.Filter.PARAM_START_COLOR);
            String endColor = params.get(FilterConfigInfo.Filter.PARAM_END_COLOR);
            if (startColor != null) {
                filter.setStartColor(parseColor(startColor));
            }
            if (endColor != null) {
                filter.setEndColor(parseColor(endColor));
            }
            return filter;
        }
        if (FilterConfigInfo.Filter.FILTER_HSL.equals(name)) {
            HueSaturationBrightnessFilter filter2 = new HueSaturationBrightnessFilter();
            String hueAdjust = params.get(FilterConfigInfo.Filter.PARAM_HUE_ADJUST);
            String saturationAdjust = params.get(FilterConfigInfo.Filter.PARAM_SATURATION_ADJUST);
            String lumAdjust = params.get(FilterConfigInfo.Filter.PARAM_LUM_ADJUST);
            String hueModify = params.get(FilterConfigInfo.Filter.PARAM_HUE_MODIFY);
            String saturationModify = params.get(FilterConfigInfo.Filter.PARAM_SATURATION_MODIFY);
            String lumModify = params.get(FilterConfigInfo.Filter.PARAM_LUM_MODIFY);
            if (hueAdjust != null) {
                filter2.setHueAdjust(Integer.parseInt(hueAdjust));
            }
            if (saturationAdjust != null) {
                filter2.setSaturationAdjust(Integer.parseInt(saturationAdjust));
            }
            if (lumAdjust != null) {
                filter2.setLumAdjust(Integer.parseInt(lumAdjust));
            }
            if (hueModify != null) {
                filter2.setHueModify(Integer.parseInt(hueModify));
            }
            if (saturationModify != null) {
                filter2.setSaturationModify(Integer.parseInt(saturationModify));
            }
            if (lumModify != null) {
                filter2.setLumModify(Integer.parseInt(lumModify));
            }
            return filter2;
        }
        return null;
    }

    private int parseColor(String colorStr) {
        try {
            if (colorStr.startsWith("#")) {
                return (int) Long.parseLong(colorStr.substring(1), 16);
            }
            return Integer.parseInt(colorStr);
        } catch (NumberFormatException e) {
            return StepOSSystemBarController.COLO_BLACK;
        }
    }

    public void cleanFilter() {
        this.isLoaded = false;
        this.mFilters.clear();
        this.mFilterConfig = null;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    private static class FilterConfigHandler extends DefaultHandler {
        private FilterConfigInfo mConfig;
        private FilterConfigInfo.Filter mCurrentFilter;
        private boolean mInIconFilters = false;

        FilterConfigHandler(FilterConfigInfo config) {
            this.mConfig = config;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (FilterConfigInfo.CONFIG_ICON_TRANSFORM.equals(qName)) {
                String version = attributes.getValue(FilterConfigInfo.ATTR_FILTER_VERSION);
                this.mConfig.setVersion(version);
                return;
            }
            if (FilterConfigInfo.CONFIG_ICON_FILTERS.equals(qName)) {
                this.mInIconFilters = true;
                return;
            }
            if (this.mInIconFilters && FilterConfigInfo.FILTER.equals(qName)) {
                String name = attributes.getValue("name");
                this.mCurrentFilter = new FilterConfigInfo.Filter(name);
            } else if (this.mCurrentFilter != null && FilterConfigInfo.Filter.PARAM.equals(qName)) {
                String paramName = attributes.getValue("name");
                String paramValue = attributes.getValue(FilterConfigInfo.Filter.PARAM_ATTR_VALUE);
                this.mCurrentFilter.addParam(paramName, paramValue);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (FilterConfigInfo.CONFIG_ICON_FILTERS.equals(qName)) {
                this.mInIconFilters = false;
            } else if (this.mInIconFilters && FilterConfigInfo.FILTER.equals(qName) && this.mCurrentFilter != null) {
                this.mConfig.addFilter(this.mCurrentFilter);
                this.mCurrentFilter = null;
            }
        }
    }
}
