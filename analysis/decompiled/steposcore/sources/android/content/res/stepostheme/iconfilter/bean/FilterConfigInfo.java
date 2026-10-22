package android.content.res.stepostheme.iconfilter.bean;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.StepOSDateTimeUrlHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class FilterConfigInfo {
    public static final String ATTR_FILTER_VERSION = "filter_version";
    public static final String ATTR_POINT_TO_X = "toX";
    public static final String ATTR_POINT_TO_Y = "toY";
    public static final String CONFIG_ICON_FILTERS = "IconFilters";
    public static final String CONFIG_ICON_POSITION = "IconPosition";
    public static final String CONFIG_ICON_TRANSFORM = "IconTransform";
    public static final String FILTER = "Filter";
    public static final String POINT = "Point";
    private List<Filter> mFilters;
    private List<Point> mPoints;
    private String mVersion;

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String version) {
        if (TextUtils.isEmpty(this.mVersion)) {
            this.mVersion = version;
        }
    }

    public void addPoint(Point point) {
        if (this.mPoints == null) {
            this.mPoints = new ArrayList(4);
        }
        this.mPoints.add(point);
    }

    public List<Point> getPoints() {
        return this.mPoints;
    }

    public void addFilter(Filter filter) {
        if (this.mFilters == null) {
            this.mFilters = new ArrayList();
        }
        this.mFilters.add(filter);
    }

    public List<Filter> getFilters() {
        return this.mFilters;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FilterConfig\n");
        if (this.mPoints != null) {
            for (Point point : this.mPoints) {
                sb.append("x:");
                sb.append(point.x);
                sb.append(", y:");
                sb.append(point.y);
                sb.append("\n");
            }
        }
        if (this.mFilters != null) {
            for (Filter filter : this.mFilters) {
                sb.append(filter.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static class Filter {
        public static final String ATTR_FILTER_NAME = "name";
        public static final String FILTER_COLOR_LEVEL = "ColorLevel";
        public static final String FILTER_EDGE_DETECT = "EdgeDetect";
        public static final String FILTER_GRADIENT_MAPPING = "GradientMapping";
        public static final String FILTER_HSL = "Hsl";
        public static final String PARAM = "Param";
        public static final String PARAM_ATTR_COLOR_CHANNEL = "ColorChannel";
        public static final String PARAM_ATTR_NAME = "name";
        public static final String PARAM_ATTR_VALUE = "value";
        public static final String PARAM_EDGE_COLOR = "EdgeColor";
        public static final String PARAM_END_COLOR = "EndColor";
        public static final String PARAM_HUE_ADJUST = "HueAdjust";
        public static final String PARAM_HUE_MODIFY = "HueModify";
        public static final String PARAM_INPUT_MAX = "InputMax";
        public static final String PARAM_INPUT_MIDDLE = "InputMiddle";
        public static final String PARAM_INPUT_MIN = "InputMin";
        public static final String PARAM_LUM_ADJUST = "LumAdjust";
        public static final String PARAM_LUM_MODIFY = "LumModify";
        public static final String PARAM_OUTPUT_MAX = "OutputMax";
        public static final String PARAM_OUTPUT_MIN = "OutputMin";
        public static final String PARAM_SATURATION_ADJUST = "SaturationAdjust";
        public static final String PARAM_SATURATION_MODIFY = "SaturationModify";
        public static final String PARAM_START_COLOR = "StartColor";
        private String name;
        private Map<String, String> params = new LinkedHashMap();

        public Filter(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void addParam(String key, String value) {
            if (this.params != null) {
                this.params.put(key, value);
            }
        }

        public Map<String, String> getParams() {
            return this.params;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Filter name: ");
            sb.append(this.name);
            sb.append(": ");
            Set<String> keys = this.params.keySet();
            for (String key : keys) {
                sb.append(key);
                sb.append(StepOSDateTimeUrlHelper.URL_TIME_STRING);
                sb.append(this.params.get(key));
                sb.append(", ");
            }
            return sb.toString();
        }
    }
}
