package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0086\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "bufStart", "", "bufEnd", "length", "getLength", "()I", "replace", "", "start", "end", MonitorConstants.CONNECT_TYPE_GET, "", "index", "toString", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PartialGapBuffer {
    public static final int $stable = 0;
    public static final int BUF_SIZE = 255;
    public static final Companion Companion = null;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd;
    private int bufStart;
    private GapBuffer buffer;
    private String text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer$Companion;", "", "<init>", "()V", "BUF_SIZE", "", "SURROUNDING_SIZE", "NOWHERE", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public final int getLength() {
        GapBuffer r100 = this.buffer;
        if (r100 != null) goto L7;
        return this.text.length();
    L7:
        return (this.text.length() - (this.bufEnd - this.bufStart)) + r100.length();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public String toString() {
        GapBuffer r100 = this.buffer;
        if (r100 == null) goto L5;
        StringBuilder r101 = new StringBuilder();
        r101.append(this.text, 0, this.bufStart);
        r100.append(r101);
        String r102 = this.text;
        r101.append(r102, this.bufEnd, r102.length());
        return r101.toString();
    L5:
        return this.text;
    }

    public final String getText() {
        return this.text;
    }

    public PartialGapBuffer(String r100) {
        this.text = r100;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final char get(int r100) {
        GapBuffer r101 = this.buffer;
        if (r101 != null) goto L7;
        return this.text.charAt(r100);
    L7:
        if (r100 < this.bufStart) goto L9;
        int r102 = r101.length();
        int r103 = this.bufStart;
        if (r100 >= (r102 + r103)) goto L15;
        return r101.get(r100 - r103);
    L15:
        return this.text.charAt(r100 - ((r102 - this.bufEnd) + r103));
    L9:
        return this.text.charAt(r100);
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void replace(int r100, int r101, String r110) {
        boolean r102 = true;
        if (r100 > r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("start index must be less than or equal to end index: " + r100 + " > " + r101);
    L8:
        if (r100 >= 0) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + r100);
    L13:
        GapBuffer r104 = this.buffer;
        if (r104 != null) goto L17;
        int r105 = Math.max(255, r110.length() + 128);
        char[] r106 = new char[r105];
        int r107 = Math.min(r100, 64);
        int r108 = Math.min(this.text.length() - r101, 64);
        int r109 = r100 - r107;
        GapBuffer_jvmKt.toCharArray(this.text, r106, 0, r109, r100);
        int r111 = r105 - r108;
        int r112 = r108 + r101;
        GapBuffer_jvmKt.toCharArray(this.text, r106, r111, r101, r112);
        GapBufferKt.access$toCharArray(r110, r106, r107);
        this.buffer = new GapBuffer(r106, r107 + r110.length(), r111);
        this.bufStart = r109;
        this.bufEnd = r112;
        return;
    L17:
        int r113 = this.bufStart;
        int r114 = r100 - r113;
        int r115 = r101 - r113;
        if (r114 >= 0) goto L20;
    L24:
        this.text = toString();
        this.buffer = null;
        this.bufStart = -1;
        this.bufEnd = -1;
        replace(r100, r101, r110);
        return;
    L20:
        if (r115 > r104.length()) goto L24;
        r104.replace(r114, r115, r110);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
