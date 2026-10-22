package pa;

import android.content.SharedPreferences;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public f f9933a;

    /* renamed from: b, reason: collision with root package name */
    public qa.c f9934b;

    /* renamed from: c, reason: collision with root package name */
    public AgentSafetyApplication f9935c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9936d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f9937e;

    /* renamed from: f, reason: collision with root package name */
    public ta.a f9938f;

    public final void a(HashMap map) {
        this.f9937e = map;
        SharedPreferences.Editor editorEdit = this.f9938f.f13291a.edit();
        editorEdit.clear();
        for (Map.Entry entry : this.f9937e.entrySet()) {
            editorEdit.putString((String) entry.getKey(), ((a) entry.getValue()).toString());
        }
        editorEdit.commit();
    }
}
