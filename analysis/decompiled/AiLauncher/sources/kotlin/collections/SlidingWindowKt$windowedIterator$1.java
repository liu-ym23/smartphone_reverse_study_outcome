package kotlin.collections;

import Ka.l;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LKa/l;", "", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend", v = 2)
/* loaded from: classes4.dex */
public final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements p<l<? super List<? extends T>>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f34711a;

    /* renamed from: b, reason: collision with root package name */
    public Object f34712b;

    /* renamed from: c, reason: collision with root package name */
    public Object f34713c;

    /* renamed from: d, reason: collision with root package name */
    public int f34714d;

    /* renamed from: e, reason: collision with root package name */
    public int f34715e;

    /* renamed from: f, reason: collision with root package name */
    public int f34716f;

    /* renamed from: g, reason: collision with root package name */
    public int f34717g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f34718h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f34719i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f34720j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Iterator<T> f34721k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f34722l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f34723m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i10, int i11, Iterator<? extends T> it, boolean z10, boolean z11, InterfaceC4014c<? super SlidingWindowKt$windowedIterator$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f34719i = i10;
        this.f34720j = i11;
        this.f34721k = it;
        this.f34722l = z10;
        this.f34723m = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.f34719i, this.f34720j, this.f34721k, this.f34722l, this.f34723m, interfaceC4014c);
        slidingWindowKt$windowedIterator$1.f34718h = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // p9.p
    public final Object invoke(l<? super List<? extends T>> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SlidingWindowKt$windowedIterator$1) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b1 -> B:17:0x005f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0143 -> B:60:0x0146). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0177 -> B:73:0x017a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
