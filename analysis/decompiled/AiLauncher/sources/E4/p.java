package E4;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"LE4/p;", "", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", "e", "(LE4/c;)V", "", ChatTracker.PREVIEW_LOADING, "", "message", Const.INTENT_KEY_UMID, "(ZLjava/lang/String;)V", "retryable", "c", "(Ljava/lang/String;Z)V", "destroy", "()V", "text", "isFinal", "f", "getCardId", "()Ljava/lang/String;", "cardId", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface p {
    static /* synthetic */ void a(p pVar, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        pVar.c(str, z10);
    }

    static /* synthetic */ void b(p pVar, boolean z10, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoading");
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        pVar.d(z10, str);
    }

    void c(String message, boolean retryable);

    void d(boolean loading, String message);

    void destroy();

    void e(FloatCardContent content);

    void f(String text, boolean isFinal);

    String getCardId();

    View getView();
}
