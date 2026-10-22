package androidx.compose.foundation.text.modifiers;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "TwoLineTextReplacement", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MinLinesConstrainerKt {
    private static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement = null;
    private static final String TwoLineTextReplacement = null;

    static {
        String r100 = StringsKt.repeat(FaceService.neutralLabel, 10);
        EmptyTextReplacement = r100;
        TwoLineTextReplacement = r100 + '\n' + r100;
    }

    public static final /* synthetic */ String access$getEmptyTextReplacement$p() {
        return EmptyTextReplacement;
    }

    public static final /* synthetic */ String access$getTwoLineTextReplacement$p() {
        return TwoLineTextReplacement;
    }
}
