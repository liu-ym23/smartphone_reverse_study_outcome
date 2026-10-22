package com.bytedance.android.live.browser.jsbridge.newmethods;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/Code;", "", "", "value", ExifInterface.LATITUDE_SOUTH, "getValue", "()S", "None", "NotReady", "Downloaded", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Code extends Enum<Code> {
    public static final Code Downloaded = null;
    public static final Code None = null;
    public static final Code NotReady = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Code[] f63236a = null;
    private final short value;

    static {
        Code r100 = new Code("None", 0, 0);
        None = r100;
        Code r101 = new Code("NotReady", 1, 1);
        NotReady = r101;
        Code r102 = new Code("Downloaded", 2, 2);
        Downloaded = r102;
        f63236a = new Code[]{r100, r101, r102};
    }

    public static Code valueOf(String r100) {
        return (Code) r27.a.a(Code.class, r100);
    }

    public static Code[] values() {
        return (Code[]) f63236a.clone();
    }

    public final short getValue() {
        return this.value;
    }

    public Code(String r100, int r101, short r102) {
        super(r100, r101);
        this.value = r102;
    }
}
