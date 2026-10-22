package io.ktor.serialization;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.serialization.ContentConverterKt$deserialize$result$2", f = "ContentConverter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ContentConverterKt$deserialize$result$2 extends SuspendLambda implements p<Object, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ ByteReadChannel $body;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConverterKt$deserialize$result$2(ByteReadChannel byteReadChannel, InterfaceC4014c<? super ContentConverterKt$deserialize$result$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$body = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ContentConverterKt$deserialize$result$2 contentConverterKt$deserialize$result$2 = new ContentConverterKt$deserialize$result$2(this.$body, interfaceC4014c);
        contentConverterKt$deserialize$result$2.L$0 = obj;
        return contentConverterKt$deserialize$result$2;
    }

    @Override // p9.p
    public final Object invoke(Object obj, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ContentConverterKt$deserialize$result$2) create(obj, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2 = this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a(obj2 != null || this.$body.isClosedForRead());
    }
}
