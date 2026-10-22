package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class af extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, ac> f2003a;

    public af() {
        this.f2003a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<String, ac> b() {
        return this.f2003a;
    }
}
