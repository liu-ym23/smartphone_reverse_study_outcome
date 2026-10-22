package ak6;

import com.bytedance.live.richcontent.engine.SpanRendClient;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public interface a {
        List<ik6.c> a();

        Map<Class<? extends ek6.b>, hk6.b<? extends ek6.b>> b();

        Map<Class<? extends ek6.d>, ik6.a<? extends ek6.d>> c();
    }

    SpanRendClient a();

    a config();
}
