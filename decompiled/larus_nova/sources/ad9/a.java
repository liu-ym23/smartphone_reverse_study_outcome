package ad9;

import com.larus.im.bean.message.block.MusicCreationContent;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<b.C0057b> f3034b;

    @Override // ad9.b
    public final String a() {
        return "";
    }

    @Override // ad9.b
    public final boolean c() {
        return false;
    }

    @Override // ad9.b
    public final MusicCreationContent d() {
        return null;
    }

    @Override // ad9.b
    public final boolean getHasNext() {
        return false;
    }

    @Override // ad9.b
    public final boolean getHasPrevious() {
        return false;
    }

    @Override // ad9.b
    public final String getItemId() {
        return "0";
    }

    @Override // ad9.b
    public final MusicCreationContent getNext() {
        return null;
    }

    @Override // ad9.b
    public final String getVid() {
        return "";
    }

    public a() {
        this.f3034b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    @Override // ad9.b
    public final MutableSharedFlow<b.C0057b> b() {
        return this.f3034b;
    }
}
