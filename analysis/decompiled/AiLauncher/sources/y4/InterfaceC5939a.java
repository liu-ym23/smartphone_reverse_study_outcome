package y4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatcore.SessionHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019À\u0006\u0003"}, d2 = {"Ly4/a;", "", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "id", Const.INTENT_KEY_APIKEY, "(I)Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lcom/stepos/agentframework/AgentUIConfig;", "agentUIConfig", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/stepos/agentframework/AgentUIConfig;)V", "destroy", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: y4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC5939a {
    default <T extends View> T a(int id) {
        return (T) getView().findViewById(id);
    }

    void b(SessionHandler handler);

    void c(Context context, AttributeSet attrs, AgentUIConfig agentUIConfig);

    void destroy();

    View getView();
}
