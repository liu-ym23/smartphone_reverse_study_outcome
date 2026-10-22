package u6;

import android.content.Context;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.taskstore.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lu6/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "baseName", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "LY8/t;", "c", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "availability", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;)Z", "", C3081a.FOCUS_MAP_NAME, "", "e", "(Ljava/util/Map;)Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "", "ALPHA_CHAT_CARD", "F", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5579b {
    public static final float ALPHA_CHAT_CARD = 0.5f;
    public static final C5579b INSTANCE = new C5579b();

    public final Set<String> a(Map<String, ? extends ArtifactAvailability> map) {
        p.i(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends ArtifactAvailability> entry : map.entrySet()) {
            if (entry.getValue() == ArtifactAvailability.BLOCKED) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }

    public final boolean b(ArtifactAvailability availability) {
        return availability == ArtifactAvailability.UNAVAILABLE;
    }

    public final void c(Context context) {
        p.i(context, "context");
        Toast.makeText(context, R$string.taskstore_artifact_expired_toast, 0).show();
    }

    public final String d(Context context, String baseName) {
        p.i(context, "context");
        p.i(baseName, "baseName");
        return baseName + context.getString(R$string.taskstore_artifact_expired_suffix);
    }

    public final Set<String> e(Map<String, ? extends ArtifactAvailability> map) {
        p.i(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends ArtifactAvailability> entry : map.entrySet()) {
            if (b(entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }
}
