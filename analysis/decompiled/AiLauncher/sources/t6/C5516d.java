package t6;

import La.D;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.audio.AudioWaveformClient;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lt6/d;", "Lcom/stepos/ailauncher/taskstore/provider/b;", "<init>", "()V", "", "taskId", "type", "Landroid/os/Bundle;", "extras", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "TAG", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: t6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5516d implements com.stepos.ailauncher.taskstore.provider.b {
    public static final C5516d INSTANCE = new C5516d();
    private static final String TAG = "RecorderTaskHook";

    @Override // com.stepos.ailauncher.taskstore.provider.b
    public void a(String taskId, String type, Bundle extras) {
        p.i(taskId, "taskId");
        p.i(type, "type");
        if (D.L(type, C5517e.RECORDER_TASK_TYPE, true)) {
            String string = extras != null ? extras.getString("status") : null;
            if (string == null) {
                string = "";
            }
            String upperCase = string.toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
            if (C5517e.TERMINAL_STATUSES.contains(upperCase)) {
                Log.i(TAG, "recorder task terminal: taskId=" + taskId + ", status=" + upperCase + ", disconnecting AIDL");
                AudioWaveformClient.INSTANCE.y();
                return;
            }
            Log.i(TAG, "recorder task active: taskId=" + taskId + ", status=" + upperCase + ", connecting AIDL");
            AudioWaveformClient.INSTANCE.v();
        }
    }
}
