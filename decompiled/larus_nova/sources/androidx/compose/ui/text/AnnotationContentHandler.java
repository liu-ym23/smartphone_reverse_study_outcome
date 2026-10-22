package androidx.compose.ui.text;

import android.text.Editable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J)\u0010\u001c\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0096\u0001J\t\u0010\"\u001a\u00020\fH\u0096\u0001J\u0019\u0010#\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J)\u0010$\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0096\u0001J)\u0010%\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010&\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010'0'H\u0096\u0001J\u0019\u0010(\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\t\u0010)\u001a\u00020\fH\u0096\u0001J)\u0010*\u001a\u00020\f2\u000e\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", BdpAppEventConstant.PARAMS_OUTPUT, "Landroid/text/Editable;", "<init>", "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "bulletIndentation", "", "currentBulletSpan", "Landroidx/compose/ui/text/BulletSpanWithLevel;", "startElement", "", "uri", "", "localName", "qName", "atts", "Lorg/xml/sax/Attributes;", "endElement", "handleAnnotationStart", "attributes", "handleAnnotationEnd", "handleUlStart", "handleUlEnd", "handleLiStart", "handleLiEnd", "commitCurrentBulletSpan", "characters", "p0", "", "kotlin.jvm.PlatformType", "p1", "p2", "endDocument", "endPrefixMapping", "ignorableWhitespace", "processingInstruction", "setDocumentLocator", "Lorg/xml/sax/Locator;", "skippedEntity", "startDocument", "startPrefixMapping", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnnotationContentHandler implements ContentHandler {
    private int bulletIndentation;
    private final ContentHandler contentHandler;
    private BulletSpanWithLevel currentBulletSpan;
    private final Editable output;

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] r100, int r101, int r102) {
        this.contentHandler.characters(r100, r101, r102);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        this.contentHandler.endDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String r100) {
        this.contentHandler.endPrefixMapping(r100);
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] r100, int r101, int r102) {
        this.contentHandler.ignorableWhitespace(r100, r101, r102);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String r100, String r101) {
        this.contentHandler.processingInstruction(r100, r101);
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator r100) {
        this.contentHandler.setDocumentLocator(r100);
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String r100) {
        this.contentHandler.skippedEntity(r100);
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
        this.contentHandler.startDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String r100, String r101) {
        this.contentHandler.startPrefixMapping(r100, r101);
    }

    private final void commitCurrentBulletSpan() {
        BulletSpanWithLevel r100 = this.currentBulletSpan;
        if (r100 == null) goto L5;
        int r101 = r100.getStart();
        int r102 = this.output.length();
        this.output.setSpan(r100, r101, r102, 33);
    L5:
        this.currentBulletSpan = null;
    }

    private final void handleAnnotationEnd() {
        Editable r100 = this.output;
        int r101 = 0;
        Object[] r102 = r100.getSpans(0, r100.length(), AnnotationSpan.class);
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        Object r106 = r102[r105];
        Editable r107 = this.output;
        if (r107.getSpanFlags((AnnotationSpan) r106) != 17) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == false) goto L10;
        r103.add(r106);
    L10:
        r105 = r105 + 1;
        goto L3
    L7:
        r108 = false;
        goto L8
    L11:
        int r109 = r103.size();
    L12:
        if (r101 >= r109) goto L17;
        AnnotationSpan r110 = (AnnotationSpan) ListProtector.get(r103, r101);
        int r111 = this.output.getSpanStart(r110);
        int r112 = this.output.length();
        this.output.removeSpan(r110);
        if (r111 == r112) goto L16;
        this.output.setSpan(r110, r111, r112, 33);
    L16:
        r101 = r101 + 1;
        goto L12
    }

    private final void handleLiStart() {
        commitCurrentBulletSpan();
        this.currentBulletSpan = new BulletSpanWithLevel(Bullet.Companion.getDefault(), this.bulletIndentation, this.output.length());
    }

    private final void handleUlEnd() {
        commitCurrentBulletSpan();
        this.bulletIndentation--;
    }

    private final void handleUlStart() {
        commitCurrentBulletSpan();
        this.bulletIndentation++;
    }

    private final void handleLiEnd() {
        commitCurrentBulletSpan();
    }

    private final void handleAnnotationStart(Attributes r100) {
        int r101 = r100.getLength();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L23;
        String r103 = r100.getLocalName(r102);
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r105 = r100.getValue(r102);
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        boolean r106 = true;
        if (r103.length() <= 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L22;
        if (r104.length() > 0) goto L20;
        r106 = false;
    L20:
        if (r106 == false) goto L22;
        int r108 = this.output.length();
        this.output.setSpan(new AnnotationSpan(r103, r104), r108, r108, 17);
    L22:
        r102 = r102 + 1;
        goto L3
    L14:
        r107 = false;
        goto L15
    }

    public AnnotationContentHandler(ContentHandler r100, Editable r101) {
        this.contentHandler = r100;
        this.output = r101;
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String r100, String r101, String r102) {
        if (r101 == null) goto L22;
        int r103 = r101.hashCode();
        if (r103 == (-1555043537)) goto L19;
        if (r103 == 3453) goto L15;
        if (r103 != 3735) goto L22;
        if (r101.equals("ul") == false) goto L22;
        handleUlEnd();
        return;
    L15:
        if (r101.equals("li") == false) goto L22;
        handleLiEnd();
        return;
    L19:
        if (r101.equals("annotation") == false) goto L22;
        handleAnnotationEnd();
        return;
    L22:
        this.contentHandler.endElement(r100, r101, r102);
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String r100, String r101, String r102, Attributes r103) {
        if (r101 == null) goto L23;
        int r104 = r101.hashCode();
        if (r104 == (-1555043537)) goto L19;
        if (r104 == 3453) goto L15;
        if (r104 != 3735) goto L23;
        if (r101.equals("ul") == false) goto L23;
        handleUlStart();
        return;
    L15:
        if (r101.equals("li") == false) goto L23;
        handleLiStart();
        return;
    L19:
        if (r101.equals("annotation") == false) goto L23;
        if (r103 == null) goto L27;
        handleAnnotationStart(r103);
        return;
    L27:
        return;
    L23:
        this.contentHandler.startElement(r100, r101, r102, r103);
    }
}
