package s3;

import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;
import java.io.File;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5235a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f5236b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f5237c;

    public /* synthetic */ a(File file, w wVar) {
        this.f5236b = file;
        this.f5237c = wVar;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f5235a) {
            case 0:
                return IndexPersistence.invalidatePersistedIndexes$lambda$1(this.f5237c, this.f5236b);
            default:
                return IndexPersistence.loadIndexFromFile$lambda$0(this.f5236b, this.f5237c);
        }
    }

    public /* synthetic */ a(w wVar, File file) {
        this.f5237c = wVar;
        this.f5236b = file;
    }
}
