package com.obric.oui.image;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/image/OImageShape;", "", "", "attrValue", "<init>", "(Ljava/lang/String;II)V", "I", "getAttrValue", "()I", "Companion", "a", "STANDARD", "ROUNDED", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OImageShape extends Enum<OImageShape> {
    private static final /* synthetic */ OImageShape[] $VALUES = null;

    @NotNull
    public static final a Companion = null;
    public static final OImageShape ROUNDED = null;
    public static final OImageShape STANDARD = null;

    @NotNull
    private static final String TAG = "OImageStyleHelper";
    private final int attrValue;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final OImageShape a(int r10) {
            OImageShape[] r11 = OImageShape.values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            OImageShape r14 = r11[r13];
            if (r14.getAttrValue() == r10) goto L9;
            r13 = r13 + 1;
        L9:
            if (r14 != null) goto L14;
            Log.w(OImageShape.TAG, "Unknown oui_imageShape value=" + r10 + ", fallback to STANDARD");
            return OImageShape.STANDARD;
        L14:
            return r14;
        L8:
            r14 = null;
            goto L9
        }

        public a() {
        }
    }

    private static final /* synthetic */ OImageShape[] $values() {
        return new OImageShape[]{STANDARD, ROUNDED};
    }

    static {
        STANDARD = new OImageShape("STANDARD", 0, 0);
        ROUNDED = new OImageShape("ROUNDED", 1, 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private OImageShape(String r10, int r11, int r12) {
        super(r10, r11);
        this.attrValue = r12;
    }

    public static OImageShape valueOf(String r10) {
        return (OImageShape) Enum.valueOf(OImageShape.class, r10);
    }

    public static OImageShape[] values() {
        return (OImageShape[]) $VALUES.clone();
    }

    public final int getAttrValue() {
        return this.attrValue;
    }
}
