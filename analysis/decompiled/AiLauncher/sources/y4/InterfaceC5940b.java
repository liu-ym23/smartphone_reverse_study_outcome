package y4;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006%\u001b\u0019+,\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00132\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\b%\u0010#J\u0019\u0010'\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001cH\u0016¢\u0006\u0004\b*\u0010\u001f¨\u0006-À\u0006\u0003"}, d2 = {"Ly4/b;", "Ly4/a;", "Ly4/b$f;", "listener", "LY8/t;", "setOnSendMessageListener", "(Ly4/b$f;)V", "Ly4/b$d;", "setOnImageClickListener", "(Ly4/b$d;)V", "Ly4/b$c;", "setOnFileClickListener", "(Ly4/b$c;)V", "Ly4/b$b;", "setOnCancelListener", "(Ly4/b$b;)V", "Ly4/b$a;", "setOnBtnPlusClickListener", "(Ly4/b$a;)V", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "id", Const.INTENT_KEY_APIKEY, "(I)Landroid/view/View;", Const.INTENT_KEY_UMID, "()V", "e", "", "isReplying", "setReplyingStatus", "(Z)V", "", "text", "setInputTxt", "(Ljava/lang/String;)V", "message", "f", "Ly4/b$e;", "setOnLoadingBubbleListener", "(Ly4/b$e;)V", "enable", "setInputMoreBtnEnable", "c", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: y4.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC5940b extends InterfaceC5939a {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Ly4/b$a;", "", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: y4.b$a */
    public interface a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Ly4/b$b;", "", "LY8/t;", "onCancel", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: y4.b$b, reason: collision with other inner class name */
    public interface InterfaceC0556b {
        void onCancel();
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Ly4/b$c;", "", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: y4.b$c */
    public interface c {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Ly4/b$d;", "", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: y4.b$d */
    public interface d {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Ly4/b$e;", "", "LY8/t;", UxipConstants.f30640D, "()V", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: y4.b$e */
    public interface e {
        default void a() {
        }

        default void onStart() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Ly4/b$f;", "", "", "message", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: y4.b$f */
    public interface f {
        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void b(f fVar, String str, List list, Map map, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClicked");
            }
            if ((i10 & 4) != 0) {
                map = null;
            }
            fVar.a(str, list, map);
        }

        void a(String message, List<FileInfo> images, Map<String, String> params);
    }

    @Override // y4.InterfaceC5939a
    default <T extends View> T a(int id) {
        return (T) getView().findViewById(id);
    }

    void d();

    void e();

    void f(String message);

    default void setInputMoreBtnEnable(boolean enable) {
    }

    void setInputTxt(String text);

    void setOnBtnPlusClickListener(a listener);

    void setOnCancelListener(InterfaceC0556b listener);

    void setOnFileClickListener(c listener);

    void setOnImageClickListener(d listener);

    default void setOnLoadingBubbleListener(e listener) {
    }

    void setOnSendMessageListener(f listener);

    void setReplyingStatus(boolean isReplying);
}
