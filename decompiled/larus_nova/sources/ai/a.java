package ai;

import io.reactivex.subjects.MaybeSubject;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, MaybeSubject<JSONObject>> f3708a;

    public a() {
        this.f3708a = new ConcurrentHashMap();
    }
}
