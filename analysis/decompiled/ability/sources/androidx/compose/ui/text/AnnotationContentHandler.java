package androidx.compose.ui.text;

import android.text.Editable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import kotlin.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0019\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\rJ7\u0010\u0018\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001f\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b!\u0010\rJ\u0010\u0010\"\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\"\u0010\rJ0\u0010$\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u00130\u00132\u000e\u0010#\u001a\n \u001d*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001¢\u0006\u0004\b$\u0010%J \u0010&\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001¢\u0006\u0004\b&\u0010'J0\u0010+\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010(0(2\u0006\u0010#\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b+\u0010,J0\u0010-\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010(0(2\u0006\u0010#\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b-\u0010,J0\u0010.\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u00130\u00132\u000e\u0010#\u001a\n \u001d*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001¢\u0006\u0004\b.\u0010%J \u0010/\u001a\u00020\t2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001¢\u0006\u0004\b/\u0010'R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u00100R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00101R\u0016\u00102\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00067"}, d2 = {"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", "Landroid/text/Editable;", "output", AppAgent.CONSTRUCT, "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "Lorg/xml/sax/Attributes;", "attributes", "LC7/r;", "handleAnnotationStart", "(Lorg/xml/sax/Attributes;)V", "handleAnnotationEnd", "()V", "handleUlStart", "handleUlEnd", "handleLiStart", "handleLiEnd", "commitCurrentBulletSpan", "", "uri", "localName", "qName", "atts", "startElement", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V", "endElement", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lorg/xml/sax/Locator;", "kotlin.jvm.PlatformType", "p0", "setDocumentLocator", "(Lorg/xml/sax/Locator;)V", "startDocument", "endDocument", "p1", "startPrefixMapping", "(Ljava/lang/String;Ljava/lang/String;)V", "endPrefixMapping", "(Ljava/lang/String;)V", "", "", "p2", "characters", "([CII)V", "ignorableWhitespace", "processingInstruction", "skippedEntity", "Lorg/xml/sax/ContentHandler;", "Landroid/text/Editable;", "bulletIndentation", "I", "Landroidx/compose/ui/text/BulletSpanWithLevel;", "currentBulletSpan", "Landroidx/compose/ui/text/BulletSpanWithLevel;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class AnnotationContentHandler implements ContentHandler {
    private int bulletIndentation;
    private final ContentHandler contentHandler;
    private BulletSpanWithLevel currentBulletSpan;
    private final Editable output;

    public AnnotationContentHandler(ContentHandler contentHandler, Editable editable) {
        this.contentHandler = contentHandler;
        this.output = editable;
    }

    private final void commitCurrentBulletSpan() {
        BulletSpanWithLevel bulletSpanWithLevel = this.currentBulletSpan;
        if (bulletSpanWithLevel != null) {
            this.output.setSpan(bulletSpanWithLevel, bulletSpanWithLevel.getStart(), this.output.length(), 33);
        }
        this.currentBulletSpan = null;
    }

    private final void handleAnnotationEnd() {
        Editable editable = this.output;
        Object[] spans = editable.getSpans(0, editable.length(), AnnotationSpan.class);
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            if (this.output.getSpanFlags((AnnotationSpan) obj) == 17) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AnnotationSpan annotationSpan = (AnnotationSpan) arrayList.get(i);
            int spanStart = this.output.getSpanStart(annotationSpan);
            int length = this.output.length();
            this.output.removeSpan(annotationSpan);
            if (spanStart != length) {
                this.output.setSpan(annotationSpan, spanStart, length, 33);
            }
        }
    }

    private final void handleAnnotationStart(Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String localName = attributes.getLocalName(i);
            if (localName == null) {
                localName = "";
            }
            String value = attributes.getValue(i);
            String str = value != null ? value : "";
            if (localName.length() > 0 && str.length() > 0) {
                int length2 = this.output.length();
                this.output.setSpan(new AnnotationSpan(localName, str), length2, length2, 17);
            }
        }
    }

    private final void handleLiEnd() {
        commitCurrentBulletSpan();
    }

    private final void handleLiStart() {
        commitCurrentBulletSpan();
        this.currentBulletSpan = new BulletSpanWithLevel(Bullet.INSTANCE.getDefault(), this.bulletIndentation, this.output.length());
    }

    private final void handleUlEnd() {
        commitCurrentBulletSpan();
        this.bulletIndentation--;
    }

    private final void handleUlStart() {
        commitCurrentBulletSpan();
        this.bulletIndentation++;
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] p02, int p1, int p22) throws SAXException {
        this.contentHandler.characters(p02, p1, p22);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        this.contentHandler.endDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName != null) {
            int iHashCode = localName.hashCode();
            if (iHashCode != -1555043537) {
                if (iHashCode != 3453) {
                    if (iHashCode == 3735 && localName.equals("ul")) {
                        handleUlEnd();
                        return;
                    }
                } else if (localName.equals("li")) {
                    handleLiEnd();
                    return;
                }
            } else if (localName.equals("annotation")) {
                handleAnnotationEnd();
                return;
            }
        }
        this.contentHandler.endElement(uri, localName, qName);
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String p02) throws SAXException {
        this.contentHandler.endPrefixMapping(p02);
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] p02, int p1, int p22) throws SAXException {
        this.contentHandler.ignorableWhitespace(p02, p1, p22);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String p02, String p1) throws SAXException {
        this.contentHandler.processingInstruction(p02, p1);
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator p02) {
        this.contentHandler.setDocumentLocator(p02);
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String p02) throws SAXException {
        this.contentHandler.skippedEntity(p02);
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.contentHandler.startDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (localName != null) {
            int iHashCode = localName.hashCode();
            if (iHashCode != -1555043537) {
                if (iHashCode != 3453) {
                    if (iHashCode == 3735 && localName.equals("ul")) {
                        handleUlStart();
                        return;
                    }
                } else if (localName.equals("li")) {
                    handleLiStart();
                    return;
                }
            } else if (localName.equals("annotation")) {
                if (atts != null) {
                    handleAnnotationStart(atts);
                    return;
                }
                return;
            }
        }
        this.contentHandler.startElement(uri, localName, qName, atts);
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String p02, String p1) throws SAXException {
        this.contentHandler.startPrefixMapping(p02, p1);
    }
}
