package ad9;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.uaigc.music.template.x;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<b.C0057b> f3042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3043e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Integer, Unit> f3046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<MusicCreationContent> f3047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList<String> f3048e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3049f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final MutableSharedFlow<b.C0057b> f3050g;

        public final void a(MusicCreationContent r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "nextNode");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            this.f3047d.add(r100);
            this.f3048e.add(r101);
            int r102 = this.f3049f;
            this.f3049f = r102 + 1;
            r100.setPlayList(new d(this, r102));
        }

        public a(String r100, boolean r101, x r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r101 = false;
        L5:
            Function1<Integer, Unit> r104 = r102;
            if ((r103 & 4) == 0) goto L8;
            r104 = new c();
        L8:
            Intrinsics.checkNotNullParameter(r100, "playListId");
            Intrinsics.checkNotNullParameter(r104, "callbackLoadMore");
            this.f3044a = r100;
            this.f3045b = r101;
            this.f3046c = r104;
            this.f3047d = new ArrayList();
            this.f3048e = new ArrayList();
            this.f3050g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        }
    }

    @Override // ad9.b
    public final String a() {
        return this.f3040b.f3044a;
    }

    @Override // ad9.b
    public final boolean getHasNext() {
        if (this.f3040b.f3047d.size() > (this.f3041c + 1)) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // ad9.b
    public final boolean getHasPrevious() {
        if (this.f3041c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ad9.b
    public final String getItemId() {
        return (String) ListProtector.get(this.f3040b.f3048e, this.f3041c);
    }

    @Override // ad9.b
    public final MusicCreationContent getNext() {
        this.f3040b.f3046c.invoke(Integer.valueOf(this.f3041c));
        if (getHasNext() == false) goto L5;
        b.f3035a.getClass();
        return b.a.f3037b.get(this.f3040b.f3044a + ((String) ListProtector.get(this.f3040b.f3048e, this.f3041c + 1)));
    L5:
        return null;
    }

    @Override // ad9.b
    public final String getVid() {
        String r100 = ((MusicCreationContent) ListProtector.get(this.f3040b.f3047d, this.f3041c)).getVid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // ad9.b
    public final MusicCreationContent d() {
        if (getHasPrevious() == false) goto L5;
        b.f3035a.getClass();
        return b.a.f3037b.get(this.f3040b.f3044a + ((String) ListProtector.get(this.f3040b.f3048e, this.f3041c - 1)));
    L5:
        return null;
    }

    @Override // ad9.b
    public final MutableSharedFlow<b.C0057b> b() {
        return this.f3042d;
    }

    @Override // ad9.b
    public final boolean c() {
        return this.f3043e;
    }

    public d(a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bindDecorator");
        this.f3040b = r100;
        this.f3041c = r101;
        this.f3042d = r100.f3050g;
        this.f3043e = r100.f3045b;
    }
}
