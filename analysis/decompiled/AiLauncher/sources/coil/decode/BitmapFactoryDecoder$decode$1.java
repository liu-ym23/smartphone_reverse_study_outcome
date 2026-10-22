package coil.decode;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", l = {231, 46}, m = "decode")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitmapFactoryDecoder$decode$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15578a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15579b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15580c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitmapFactoryDecoder f15581d;

    /* renamed from: e, reason: collision with root package name */
    public int f15582e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapFactoryDecoder$decode$1(BitmapFactoryDecoder bitmapFactoryDecoder, InterfaceC4014c<? super BitmapFactoryDecoder$decode$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15581d = bitmapFactoryDecoder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15580c = obj;
        this.f15582e |= Integer.MIN_VALUE;
        return this.f15581d.a(this);
    }
}
