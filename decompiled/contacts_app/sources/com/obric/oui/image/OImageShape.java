package com.obric.oui.image;

import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OImageStyleHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/oui/image/OImageShape;", "", "attrValue", "", "(Ljava/lang/String;II)V", "getAttrValue", "()I", "STANDARD", "ROUNDED", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OImageShape extends Enum<OImageShape> {
    private static final /* synthetic */ OImageShape[] $VALUES = null;
    public static final Companion Companion = null;
    public static final OImageShape ROUNDED = null;
    public static final OImageShape STANDARD = null;
    private static final String TAG = "OImageStyleHelper";
    private final int attrValue;

    /* JADX INFO: compiled from: OImageStyleHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/image/OImageShape$Companion;", "", "()V", "TAG", "", "fromAttrValue", "Lcom/obric/oui/image/OImageShape;", "value", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final OImageShape fromAttrValue(int r7) {
            OImageShape[] r0 = OImageShape.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            OImageShape r4 = r0[r3];
            if (r4.getAttrValue() != r7) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 != null) goto L17;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(OImageShape.TAG, "Unknown oui_imageShape value=" + r7 + ", fallback to STANDARD");
            return OImageShape.STANDARD;
        L17:
            return r4;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    private static final /* synthetic */ OImageShape[] $values() {
        return new OImageShape[]{STANDARD, ROUNDED};
    }

    public static OImageShape valueOf(String r1) {
        return (OImageShape) Enum.valueOf(OImageShape.class, r1);
    }

    public static OImageShape[] values() {
        return (OImageShape[]) $VALUES.clone();
    }

    private OImageShape(String r1, int r2, int r3) {
        super(r1, r2);
        this.attrValue = r3;
    }

    public final int getAttrValue() {
        return this.attrValue;
    }

    static {
        STANDARD = new OImageShape("STANDARD", 0, 0);
        ROUNDED = new OImageShape("ROUNDED", 1, 1);
        $VALUES = $values();
        Companion = new Companion(null);
    }
}
