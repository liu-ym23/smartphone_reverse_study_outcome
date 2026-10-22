package ad2;

import com.bytedance.android.livesdk.config.dj1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.bduploader.BDImageUploader;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f2978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDImageUploader f2979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f2980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f2981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f2982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f2983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f2984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Boolean f2985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ CallContext f2986i;

    public n(k r100, BDImageUploader r101, List r102, String r103, String r104, String r105, String r106, Boolean r107, CallContext r108) {
        this.f2978a = r100;
        this.f2979b = r101;
        this.f2980c = r102;
        this.f2981d = r103;
        this.f2982e = r104;
        this.f2983f = r105;
        this.f2984g = r106;
        this.f2985h = r107;
        this.f2986i = r108;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Pair<Integer, com.bytedance.android.livesdk.jsbridge.methods.upload.models.a>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        BDImageUploader r101 = this.f2979b;
        int r102 = this.f2980c.size();
        Object[] r103 = this.f2980c.toArray(new String[0]);
        if (r103 == null) goto L10;
        r101.setFilePath(r102, (String[]) r103);
        this.f2979b.setTopAccessKey(this.f2981d);
        this.f2979b.setTopSecretKey(this.f2982e);
        this.f2979b.setTopSessionToken(this.f2983f);
        this.f2979b.setSpaceName(this.f2984g);
        BDImageUploader r104 = this.f2979b;
        dj1 r105 = dj1.f120039a;
        r104.setUploadDomain(r105.getValue().a());
        this.f2979b.setSliceSize(r105.getValue().b());
        this.f2979b.setMaxConcurrentFileNum(this.f2980c.size());
        TreeMap<String, Object> r106 = new TreeMap();
        r106.put("policy-set", "check,thumb,medium,large");
        this.f2979b.setPolicyParams(r106);
        this.f2979b.setObjectType("image");
        if (Intrinsics.areEqual(this.f2985h, Boolean.TRUE) == false) goto L7;
        this.f2979b.setConfig(new TreeMap(MapsKt.mapOf(TuplesKt.to("copies", "both"))));
        BDImageUploader r107 = this.f2979b;
        int r108 = k.f2969a;
        r107.setProcessActionType(1);
    L7:
        BDImageUploader r109 = this.f2979b;
        k r110 = this.f2978a;
        int r111 = this.f2980c.size();
        CallContext r112 = this.f2986i;
        r110.getClass();
        r109.setListener(new l(r100, r109, r111, r112));
        this.f2979b.start();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
