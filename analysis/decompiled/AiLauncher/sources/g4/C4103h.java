package g4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lg4/h;", "", "<init>", "()V", "", "feedbackType", "Ljava/lang/String;", "getFeedbackType", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g4.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4103h {

    @SerializedName("feedback_type")
    private String feedbackType;

    public final void a(String str) {
        this.feedbackType = str;
    }
}
