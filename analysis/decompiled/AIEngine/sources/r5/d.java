package r5;

import com.stepos.core.ability.speech.AsrCloudWsSession;
import h0.e;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements s5.a {

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadPoolExecutor f11734c;

    /* renamed from: a, reason: collision with root package name */
    public final e f11735a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, Float> f11736b;

    static {
        int iMax = Math.max(2, Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iMax, iMax, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(1000), new com.stepos.aicgroup.d(8), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f11734c = threadPoolExecutor;
    }

    public d(e eVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Float fValueOf = Float.valueOf(0.5f);
        linkedHashMap.put("political#national_institute_policy", fValueOf);
        linkedHashMap.put("political#reaction", fValueOf);
        linkedHashMap.put("political#N1", fValueOf);
        linkedHashMap.put("political#political_common", fValueOf);
        linkedHashMap.put("political#history_leader", fValueOf);
        linkedHashMap.put("political#important_leader", fValueOf);
        linkedHashMap.put("political#64_event", fValueOf);
        linkedHashMap.put("political#sensitive_event", fValueOf);
        linkedHashMap.put("political#national_image", fValueOf);
        linkedHashMap.put("political#heresy", fValueOf);
        linkedHashMap.put("political#fallen_official", fValueOf);
        linkedHashMap.put("political#national_meeting", fValueOf);
        linkedHashMap.put("political#martyr", fValueOf);
        linkedHashMap.put("political#hot_news", fValueOf);
        linkedHashMap.put("sexual#sex_event", fValueOf);
        linkedHashMap.put("sexual#sex_organ", fValueOf);
        linkedHashMap.put("sexual#sex_intion", fValueOf);
        linkedHashMap.put("sexual#sex_intention", fValueOf);
        linkedHashMap.put("sexual#pornographic_insinuate", fValueOf);
        linkedHashMap.put("illegal#prohibited_acts", fValueOf);
        linkedHashMap.put("illegal#gamble", fValueOf);
        linkedHashMap.put("illegal#contraband", fValueOf);
        linkedHashMap.put("illegal#drugs", fValueOf);
        linkedHashMap.put("illegal#weapon", fValueOf);
        linkedHashMap.put("illegal#illegal_group", fValueOf);
        linkedHashMap.put("morality#abuse_and_insults", fValueOf);
        linkedHashMap.put("morality#discrimination_and_insult", fValueOf);
        linkedHashMap.put("self_harm#suicide", fValueOf);
        linkedHashMap.put("self_harm#self_injurious", fValueOf);
        if (linkedHashMap.isEmpty()) {
            throw new IllegalArgumentException("thresholds must not be empty");
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry.getKey() == null || ((String) entry.getKey()).trim().isEmpty()) {
                throw new IllegalArgumentException("threshold head must not be blank");
            }
            Float f8 = (Float) entry.getValue();
            if (f8 == null || f8.floatValue() < 0.0f || f8.floatValue() > 1.0f) {
                throw new IllegalArgumentException("threshold must be in [0, 1]: head=" + ((String) entry.getKey()));
            }
        }
        this.f11735a = eVar;
        this.f11736b = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
    }

    @Override // s5.a
    public final Future<Boolean> a(final String str) {
        return f11734c.submit(new Callable() { // from class: r5.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f11732a.b(str));
            }
        });
    }

    @Override // s5.a
    public final boolean b(String str) {
        String strA = o5.d.a(str);
        if (strA.isEmpty()) {
            return false;
        }
        boolean[] zArr = {false};
        t5.a.a(strA, AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS, 20, new com.stepos.core.ota.downloader.b(this, zArr));
        return zArr[0];
    }

    @Override // s5.a
    public final boolean c() {
        return true;
    }
}
