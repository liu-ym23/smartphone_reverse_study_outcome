package ch.qos.logback.core.joran.action;

import B0.g;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.event.SaxEventRecorder;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.OptionHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class IncludeAction extends Action {
    private static final String FILE_ATTR = "file";
    private static final String INCLUDED_TAG = "included";
    private static final String OPTIONAL_ATTR = "optional";
    private static final String RESOURCE_ATTR = "resource";
    private static final String URL_ATTR = "url";
    private String attributeInUse;
    private boolean optional;

    private boolean checkAttributes(Attributes attributes) {
        String value = attributes.getValue("file");
        String value2 = attributes.getValue("url");
        String value3 = attributes.getValue(RESOURCE_ATTR);
        int i4 = !OptionHelper.isEmpty(value) ? 1 : 0;
        if (!OptionHelper.isEmpty(value2)) {
            i4++;
        }
        if (!OptionHelper.isEmpty(value3)) {
            i4++;
        }
        if (i4 == 0) {
            addError("One of \"path\", \"resource\" or \"url\" attributes must be set.");
            return false;
        }
        if (i4 > 1) {
            addError("Only one of \"file\", \"url\" or \"resource\" attributes should be set.");
            return false;
        }
        if (i4 == 1) {
            return true;
        }
        throw new IllegalStateException(g.j("Count value [", i4, "] is not expected"));
    }

    private InputStream getInputStreamByFilePath(String str) {
        try {
            return new FileInputStream(str);
        } catch (IOException unused) {
            addWarn("File [" + str + "] does not exist.");
            return null;
        }
    }

    private InputStream getInputStreamByResource(URL url) {
        return openURL(url);
    }

    private InputStream getInputStreamByUrl(URL url) {
        return openURL(url);
    }

    private void parseAndRecord(InputStream inputStream, SaxEventRecorder saxEventRecorder) throws SAXException, JoranException, IOException {
        saxEventRecorder.setContext(this.context);
        saxEventRecorder.recordEvents(inputStream);
    }

    private void trimHeadAndTail(SaxEventRecorder saxEventRecorder) {
        List<SaxEvent> list = saxEventRecorder.saxEventList;
        if (list.size() == 0) {
            return;
        }
        SaxEvent saxEvent = list.get(0);
        if (saxEvent != null && saxEvent.qName.equalsIgnoreCase(INCLUDED_TAG)) {
            list.remove(0);
        }
        SaxEvent saxEvent2 = list.get(saxEventRecorder.saxEventList.size() - 1);
        if (saxEvent2 == null || !saxEvent2.qName.equalsIgnoreCase(INCLUDED_TAG)) {
            return;
        }
        list.remove(saxEventRecorder.saxEventList.size() - 1);
    }

    public URL attributeToURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e4) {
            addError("URL [" + str + "] is not well formed.", e4);
            return null;
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException, IOException {
        SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
        this.attributeInUse = null;
        this.optional = OptionHelper.toBoolean(attributes.getValue(OPTIONAL_ATTR), false);
        if (checkAttributes(attributes)) {
            InputStream inputStream = getInputStream(interpretationContext, attributes);
            if (inputStream != null) {
                try {
                    try {
                        parseAndRecord(inputStream, saxEventRecorder);
                        trimHeadAndTail(saxEventRecorder);
                        interpretationContext.getJoranInterpreter().getEventPlayer().addEventsDynamically(saxEventRecorder.saxEventList, 2);
                    } catch (JoranException e4) {
                        addError("Error while parsing  " + this.attributeInUse, e4);
                    }
                } finally {
                    close(inputStream);
                }
            }
        }
    }

    public void close(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
    }

    public URL filePathAsURL(String str) {
        try {
            return new File(str).toURI().toURL();
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public InputStream getInputStream(InterpretationContext interpretationContext, Attributes attributes) {
        URL inputURL = getInputURL(interpretationContext, attributes);
        if (inputURL == null) {
            return null;
        }
        ConfigurationWatchListUtil.addToWatchList(this.context, inputURL);
        return openURL(inputURL);
    }

    public URL getInputURL(InterpretationContext interpretationContext, Attributes attributes) {
        String value = attributes.getValue("file");
        String value2 = attributes.getValue("url");
        String value3 = attributes.getValue(RESOURCE_ATTR);
        if (!OptionHelper.isEmpty(value)) {
            String strSubst = interpretationContext.subst(value);
            this.attributeInUse = strSubst;
            return filePathAsURL(strSubst);
        }
        if (!OptionHelper.isEmpty(value2)) {
            String strSubst2 = interpretationContext.subst(value2);
            this.attributeInUse = strSubst2;
            return attributeToURL(strSubst2);
        }
        if (OptionHelper.isEmpty(value3)) {
            throw new IllegalStateException("A URL stream should have been returned");
        }
        String strSubst3 = interpretationContext.subst(value3);
        this.attributeInUse = strSubst3;
        return resourceAsURL(strSubst3);
    }

    public InputStream openURL(URL url) {
        try {
            return url.openStream();
        } catch (IOException e4) {
            if (this.optional) {
                return null;
            }
            this.addError("Failed to open [" + url.toString() + "]", e4);
            return null;
        }
    }

    public URL resourceAsURL(String str) {
        URL resourceBySelfClassLoader = Loader.getResourceBySelfClassLoader(str);
        if (resourceBySelfClassLoader != null) {
            return resourceBySelfClassLoader;
        }
        if (this.optional) {
            return null;
        }
        addError("Could not find resource corresponding to [" + str + "]");
        return null;
    }
}
