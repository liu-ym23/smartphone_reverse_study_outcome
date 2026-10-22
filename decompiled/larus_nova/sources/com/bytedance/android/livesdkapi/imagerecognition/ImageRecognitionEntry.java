package com.bytedance.android.livesdkapi.imagerecognition;

import com.bytedance.android.ec.core.event.a;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionEntry;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "LongPressPanel", "ClearScreen", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ImageRecognitionEntry extends Enum<ImageRecognitionEntry> {
    private static final /* synthetic */ ImageRecognitionEntry[] $VALUES = null;
    public static final ImageRecognitionEntry ClearScreen = null;
    public static final Companion Companion = null;
    public static final ImageRecognitionEntry LongPressPanel = null;
    private final String desc;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionEntry$Companion;", "", "()V", "from", "Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionEntry;", SocialConstants.PARAM_APP_DESC, "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ImageRecognitionEntry from(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            ImageRecognitionEntry[] r101 = ImageRecognitionEntry.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ImageRecognitionEntry r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getDesc(), r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }
    }

    static {
        ImageRecognitionEntry r100 = new ImageRecognitionEntry("LongPressPanel", 0, a.VALUE_LONG_CLICK);
        LongPressPanel = r100;
        ImageRecognitionEntry r101 = new ImageRecognitionEntry("ClearScreen", 1, "screen_clear");
        ClearScreen = r101;
        $VALUES = new ImageRecognitionEntry[]{r100, r101};
        Companion = new Companion(null);
    }

    public static ImageRecognitionEntry valueOf(String r100) {
        return (ImageRecognitionEntry) r27.a.a(ImageRecognitionEntry.class, r100);
    }

    public static ImageRecognitionEntry[] values() {
        return (ImageRecognitionEntry[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    private ImageRecognitionEntry(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
