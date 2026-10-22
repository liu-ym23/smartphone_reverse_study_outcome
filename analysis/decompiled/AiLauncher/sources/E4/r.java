package E4;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\"À\u0006\u0003"}, d2 = {"LE4/r;", "", "Lcom/stepos/agentframework/floatcard/api/FloatCardScene;", HomeGestureEligibilityContract.EXTRA_SCENE, "", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/floatcard/api/FloatCardScene;)Z", "LE4/p;", "card", "LE4/i;", "options", "LY8/t;", "c", "(LE4/p;LE4/i;)V", "", "cardId", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "f", "(Ljava/lang/String;LE4/c;)V", "animated", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "hostId", "", "e", "()I", "priority", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface r {
    String a();

    void b(String cardId, boolean animated);

    void c(p card, FloatCardOptions options);

    boolean d(FloatCardScene scene);

    int e();

    void f(String cardId, FloatCardContent content);

    Context getContext();
}
