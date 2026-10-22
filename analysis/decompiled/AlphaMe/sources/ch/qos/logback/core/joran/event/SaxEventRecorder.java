package ch.qos.logback.core.joran.event;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.ContextAwareImpl;
import ch.qos.logback.core.status.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class SaxEventRecorder extends DefaultHandler implements ContextAware {
    final ContextAwareImpl cai;
    Locator locator;
    public List<SaxEvent> saxEventList = new ArrayList();
    ElementPath globalElementPath = new ElementPath();

    public SaxEventRecorder(Context context) {
        this.cai = new ContextAwareImpl(context, this);
    }

    private SAXParser buildSaxParser() throws JoranException {
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setValidating(false);
            sAXParserFactoryNewInstance.setNamespaceAware(true);
            return sAXParserFactoryNewInstance.newSAXParser();
        } catch (Exception e4) {
            this.addError("Parser configuration error occurred", e4);
            throw new JoranException("Parser configuration error occurred", e4);
        }
    }

    private void handleError(String str, Throwable th) throws JoranException {
        addError(str, th);
        throw new JoranException(str, th);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addError(String str) {
        this.cai.addError(str);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addInfo(String str) {
        this.cai.addInfo(str);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addStatus(Status status) {
        this.cai.addStatus(status);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addWarn(String str) {
        this.cai.addWarn(str);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i4, int i5) {
        String str = new String(cArr, i4, i5);
        SaxEvent lastEvent = getLastEvent();
        if (lastEvent instanceof BodyEvent) {
            ((BodyEvent) lastEvent).append(str);
        } else {
            if (isSpaceOnly(str)) {
                return;
            }
            this.saxEventList.add(new BodyEvent(str, getLocator()));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        this.saxEventList.add(new EndEvent(str, str2, str3, getLocator()));
        this.globalElementPath.pop();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        addError("XML_PARSING - Parsing error on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber(), sAXParseException);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        addError("XML_PARSING - Parsing fatal error on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber(), sAXParseException);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public Context getContext() {
        return this.cai.getContext();
    }

    public SaxEvent getLastEvent() {
        if (this.saxEventList.isEmpty()) {
            return null;
        }
        return this.saxEventList.get(this.saxEventList.size() - 1);
    }

    public Locator getLocator() {
        return this.locator;
    }

    public List<SaxEvent> getSaxEventList() {
        return this.saxEventList;
    }

    public String getTagName(String str, String str2) {
        return (str == null || str.length() < 1) ? str2 : str;
    }

    public boolean isSpaceOnly(String str) {
        return str.trim().length() == 0;
    }

    public final void recordEvents(InputStream inputStream) throws SAXException, JoranException, IOException {
        recordEvents(new InputSource(inputStream));
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        this.cai.setContext(context);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.globalElementPath.push(getTagName(str2, str3));
        this.saxEventList.add(new StartEvent(this.globalElementPath.duplicate(), str, str2, str3, attributes, getLocator()));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        addWarn("XML_PARSING - Parsing warning on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber(), sAXParseException);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addError(String str, Throwable th) {
        this.cai.addError(str, th);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addInfo(String str, Throwable th) {
        this.cai.addInfo(str, th);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void addWarn(String str, Throwable th) {
        this.cai.addWarn(str, th);
    }

    public List<SaxEvent> recordEvents(InputSource inputSource) throws SAXException, JoranException, IOException {
        try {
            buildSaxParser().parse(inputSource, this);
            return this.saxEventList;
        } catch (IOException e4) {
            this.handleError("I/O error occurred while parsing xml file", e4);
            throw new IllegalStateException("This point can never be reached");
        } catch (SAXException e5) {
            throw new JoranException("Problem parsing XML document. See previously reported errors.", e5);
        } catch (Exception e6) {
            this.handleError("Unexpected exception while parsing XML document.", e6);
            throw new IllegalStateException("This point can never be reached");
        }
    }
}
