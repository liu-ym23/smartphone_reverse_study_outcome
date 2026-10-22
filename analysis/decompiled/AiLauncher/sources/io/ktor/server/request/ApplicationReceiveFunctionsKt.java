package io.ktor.server.request;

import La.C0953c;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import fb.v;
import g9.InterfaceC4112d;
import io.ktor.http.BadContentTypeFormatException;
import io.ktor.http.HttpHeaders;
import io.ktor.http.Parameters;
import io.ktor.http.content.MultiPartData;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.plugins.BadRequestException;
import io.ktor.server.plugins.CannotTransformContentToTypeException;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087H¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0086H¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086H¢\u0006\u0004\b\u0006\u0010\u0004\u001a,\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@¢\u0006\u0004\b\u0005\u0010\t\u001a\"\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0005\u0010\f\u001a(\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0087@¢\u0006\u0004\b\u0003\u0010\f\u001a.\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@¢\u0006\u0004\b\u0003\u0010\t\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0002H\u0086H¢\u0006\u0004\b\u000e\u0010\u0004\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0086H¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086H¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0002H\u0086H¢\u0006\u0004\b\u0017\u0010\u0004\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\" \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e\"(\u0010\u0012\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#*\n\u0010%\"\u00020$2\u00020$¨\u0006&"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/server/application/ApplicationCall;", "receiveOrNull", "(Lio/ktor/server/application/ApplicationCall;Le9/c;)Ljava/lang/Object;", "receive", "receiveNullable", "Lw9/d;", "type", "(Lio/ktor/server/application/ApplicationCall;Lw9/d;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "", "receiveText", "Lio/ktor/utils/io/ByteReadChannel;", "receiveChannel", "", "formFieldLimit", "Lio/ktor/http/content/MultiPartData;", "receiveMultipart", "(Lio/ktor/server/application/ApplicationCall;JLe9/c;)Ljava/lang/Object;", "Lio/ktor/http/Parameters;", "receiveParameters", "Lio/ktor/util/AttributeKey;", "FORM_FIELD_LIMIT", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/request/DoubleReceivePreventionToken;", "DoubleReceivePreventionTokenKey", "getDoubleReceivePreventionTokenKey", "()Lio/ktor/util/AttributeKey;", UxipConstants.f30680s, "getFormFieldLimit", "(Lio/ktor/server/application/ApplicationCall;)J", "setFormFieldLimit", "(Lio/ktor/server/application/ApplicationCall;J)V", "Lio/ktor/server/plugins/ContentTransformationException;", "ContentTransformationException", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationReceiveFunctionsKt {
    private static final AttributeKey<DoubleReceivePreventionToken> DoubleReceivePreventionTokenKey;
    private static final AttributeKey<Long> FORM_FIELD_LIMIT;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {112}, m = "receive")
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receive((ApplicationCall) null, (InterfaceC5745d) null, this);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {125}, m = "receive")
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$3, reason: invalid class name */
    public static final class AnonymousClass3<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receive((ApplicationCall) null, (TypeInfo) null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {278}, m = "receiveChannel")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receiveChannel(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {278}, m = "receiveMultipart")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveMultipart$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43891 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43891(InterfaceC4014c<? super C43891> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receiveMultipart(null, 0L, this);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {143}, m = "receiveOrNull")
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43902<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43902(InterfaceC4014c<? super C43902> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receiveOrNull((ApplicationCall) null, (TypeInfo) null, this);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {DidiCardView.FINISHED_SUMMARY_WIDTH_DP}, m = "receiveOrNull")
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$3, reason: invalid class name and case insensitive filesystem */
    public static final class C43913<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43913(InterfaceC4014c<? super C43913> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receiveOrNull((ApplicationCall) null, (InterfaceC5745d) null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {278}, m = "receiveParameters")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveParameters$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43921 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43921(InterfaceC4014c<? super C43921> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receiveParameters(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", l = {279, 185}, m = "receiveText")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43931(InterfaceC4014c<? super C43931> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsKt.receiveText(null, this);
        }
    }

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(Long.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = t.m(Long.TYPE);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        FORM_FIELD_LIMIT = new AttributeKey<>("FormFieldLimit", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = t.b(DoubleReceivePreventionToken.class);
        try {
            interfaceC5755nM2 = t.m(DoubleReceivePreventionToken.class);
        } catch (Throwable unused2) {
        }
        DoubleReceivePreventionTokenKey = new AttributeKey<>("DoubleReceivePreventionToken", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
    }

    public static final AttributeKey<DoubleReceivePreventionToken> getDoubleReceivePreventionTokenKey() {
        return DoubleReceivePreventionTokenKey;
    }

    public static final long getFormFieldLimit(ApplicationCall applicationCall) {
        p.i(applicationCall, "<this>");
        Long l10 = (Long) applicationCall.getAttributes().getOrNull(FORM_FIELD_LIMIT);
        return l10 != null ? l10.longValue() : ApplicationReceiveFunctionsJvmKt.getDEFAULT_FORM_FIELD_LIMIT();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object receive(io.ktor.server.application.ApplicationCall r4, w9.InterfaceC5745d<T> r5, e9.InterfaceC4014c<? super T> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$2 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$2 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$2
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r6)
            goto L46
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r6)
            w9.n r6 = io.ktor.server.application.internal.TypeUtilsJvmKt.starProjectedTypeBridge(r5)
            io.ktor.util.reflect.TypeInfo r2 = new io.ktor.util.reflect.TypeInfo
            r2.<init>(r5, r6)
            r0.label = r3
            java.lang.Object r6 = r4.receiveNullable(r2, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            kotlin.jvm.internal.p.f(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receive(io.ktor.server.application.ApplicationCall, w9.d, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object receiveChannel(io.ktor.server.application.ApplicationCall r7, e9.InterfaceC4014c<? super io.ktor.utils.io.ByteReadChannel> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveChannel$1 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveChannel$1 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveChannel$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r5 = io.ktor.utils.io.ByteReadChannel.class
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.C4849c.b(r8)
            goto L4f
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.C4849c.b(r8)
            w9.d r8 = kotlin.jvm.internal.t.b(r5)
            w9.n r2 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L40
            goto L41
        L40:
            r2 = r3
        L41:
            io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo
            r6.<init>(r8, r2)
            r0.label = r4
            java.lang.Object r8 = r7.receiveNullable(r6, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            if (r8 == 0) goto L52
            return r8
        L52:
            w9.d r7 = kotlin.jvm.internal.t.b(r5)
            w9.n r3 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L5a
        L5a:
            io.ktor.util.reflect.TypeInfo r8 = new io.ktor.util.reflect.TypeInfo
            r8.<init>(r7, r3)
            w9.n r7 = r8.getKotlinType()
            kotlin.jvm.internal.p.f(r7)
            io.ktor.server.plugins.CannotTransformContentToTypeException r8 = new io.ktor.server.plugins.CannotTransformContentToTypeException
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receiveChannel(io.ktor.server.application.ApplicationCall, e9.c):java.lang.Object");
    }

    private static final Object receiveChannel$$forInline(ApplicationCall applicationCall, InterfaceC4014c<? super ByteReadChannel> interfaceC4014c) throws CannotTransformContentToTypeException {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(ByteReadChannel.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = t.m(ByteReadChannel.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        if (objReceiveNullable != null) {
            return objReceiveNullable;
        }
        InterfaceC5745d interfaceC5745dB2 = t.b(ByteReadChannel.class);
        try {
            interfaceC5755nM2 = t.m(ByteReadChannel.class);
        } catch (Throwable unused2) {
        }
        InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, interfaceC5755nM2).getKotlinType();
        p.f(kotlinType);
        throw new CannotTransformContentToTypeException(kotlinType);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object receiveMultipart(io.ktor.server.application.ApplicationCall r8, long r9, e9.InterfaceC4014c<? super io.ktor.http.content.MultiPartData> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.C43891
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveMultipart$1 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.C43891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveMultipart$1 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveMultipart$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.Class<io.ktor.http.content.MultiPartData> r5 = io.ktor.http.content.MultiPartData.class
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.C4849c.b(r11)
            goto L58
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            kotlin.C4849c.b(r11)
            r6 = 0
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L40
            setFormFieldLimit(r8, r9)
        L40:
            w9.d r9 = kotlin.jvm.internal.t.b(r5)
            w9.n r10 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L49
            goto L4a
        L49:
            r10 = r3
        L4a:
            io.ktor.util.reflect.TypeInfo r11 = new io.ktor.util.reflect.TypeInfo
            r11.<init>(r9, r10)
            r0.label = r4
            java.lang.Object r11 = r8.receiveNullable(r11, r0)
            if (r11 != r1) goto L58
            return r1
        L58:
            if (r11 == 0) goto L5b
            return r11
        L5b:
            w9.d r8 = kotlin.jvm.internal.t.b(r5)
            w9.n r3 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L63
        L63:
            io.ktor.util.reflect.TypeInfo r9 = new io.ktor.util.reflect.TypeInfo
            r9.<init>(r8, r3)
            w9.n r8 = r9.getKotlinType()
            kotlin.jvm.internal.p.f(r8)
            io.ktor.server.plugins.CannotTransformContentToTypeException r9 = new io.ktor.server.plugins.CannotTransformContentToTypeException
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receiveMultipart(io.ktor.server.application.ApplicationCall, long, e9.c):java.lang.Object");
    }

    private static final Object receiveMultipart$$forInline(ApplicationCall applicationCall, long j10, InterfaceC4014c<? super MultiPartData> interfaceC4014c) throws CannotTransformContentToTypeException {
        InterfaceC5755n interfaceC5755nM;
        if (j10 > 0) {
            setFormFieldLimit(applicationCall, j10);
        }
        InterfaceC5745d interfaceC5745dB = t.b(MultiPartData.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = t.m(MultiPartData.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        if (objReceiveNullable != null) {
            return objReceiveNullable;
        }
        InterfaceC5745d interfaceC5745dB2 = t.b(MultiPartData.class);
        try {
            interfaceC5755nM2 = t.m(MultiPartData.class);
        } catch (Throwable unused2) {
        }
        InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, interfaceC5755nM2).getKotlinType();
        p.f(kotlinType);
        throw new CannotTransformContentToTypeException(kotlinType);
    }

    public static /* synthetic */ Object receiveMultipart$default(ApplicationCall applicationCall, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) throws CannotTransformContentToTypeException {
        InterfaceC5755n interfaceC5755nM;
        if ((i10 & 1) != 0) {
            j10 = -1;
        }
        if (j10 > 0) {
            setFormFieldLimit(applicationCall, j10);
        }
        InterfaceC5745d interfaceC5745dB = t.b(MultiPartData.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = t.m(MultiPartData.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        if (objReceiveNullable != null) {
            return objReceiveNullable;
        }
        InterfaceC5745d interfaceC5745dB2 = t.b(MultiPartData.class);
        try {
            interfaceC5755nM2 = t.m(MultiPartData.class);
        } catch (Throwable unused2) {
        }
        InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, interfaceC5755nM2).getKotlinType();
        p.f(kotlinType);
        throw new CannotTransformContentToTypeException(kotlinType);
    }

    public static final /* synthetic */ <T> Object receiveNullable(ApplicationCall applicationCall, InterfaceC4014c<? super T> interfaceC4014c) {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        return objReceiveNullable;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object receiveOrNull(io.ktor.server.application.ApplicationCall r4, io.ktor.util.reflect.TypeInfo r5, e9.InterfaceC4014c<? super T> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.C43902
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$2 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.C43902) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$2 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$2
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            io.ktor.server.application.ApplicationCall r4 = (io.ktor.server.application.ApplicationCall) r4
            kotlin.C4849c.b(r6)     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            return r6
        L2d:
            r5 = move-exception
            goto L46
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r6)
            r0.L$0 = r4     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            r0.label = r3     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            java.lang.Object r4 = r4.receiveNullable(r5, r0)     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            if (r4 != r1) goto L45
            return r1
        L45:
            return r4
        L46:
            io.ktor.server.application.Application r4 = r4.getApplication()
            vc.c r4 = io.ktor.server.application.ApplicationKt.getLog(r4)
            java.lang.String r6 = "Conversion failed, null returned"
            r4.debug(r6, r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receiveOrNull(io.ktor.server.application.ApplicationCall, io.ktor.util.reflect.TypeInfo, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object receiveParameters(io.ktor.server.application.ApplicationCall r7, e9.InterfaceC4014c<? super io.ktor.http.Parameters> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.C43921
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveParameters$1 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.C43921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveParameters$1 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveParameters$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.Class<io.ktor.http.Parameters> r5 = io.ktor.http.Parameters.class
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.C4849c.b(r8)
            goto L4f
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.C4849c.b(r8)
            w9.d r8 = kotlin.jvm.internal.t.b(r5)
            w9.n r2 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L40
            goto L41
        L40:
            r2 = r3
        L41:
            io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo
            r6.<init>(r8, r2)
            r0.label = r4
            java.lang.Object r8 = r7.receiveNullable(r6, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            if (r8 == 0) goto L52
            return r8
        L52:
            w9.d r7 = kotlin.jvm.internal.t.b(r5)
            w9.n r3 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L5a
        L5a:
            io.ktor.util.reflect.TypeInfo r8 = new io.ktor.util.reflect.TypeInfo
            r8.<init>(r7, r3)
            w9.n r7 = r8.getKotlinType()
            kotlin.jvm.internal.p.f(r7)
            io.ktor.server.plugins.CannotTransformContentToTypeException r8 = new io.ktor.server.plugins.CannotTransformContentToTypeException
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receiveParameters(io.ktor.server.application.ApplicationCall, e9.c):java.lang.Object");
    }

    private static final Object receiveParameters$$forInline(ApplicationCall applicationCall, InterfaceC4014c<? super Parameters> interfaceC4014c) throws CannotTransformContentToTypeException {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(Parameters.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = t.m(Parameters.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        if (objReceiveNullable != null) {
            return objReceiveNullable;
        }
        InterfaceC5745d interfaceC5745dB2 = t.b(Parameters.class);
        try {
            interfaceC5755nM2 = t.m(Parameters.class);
        } catch (Throwable unused2) {
        }
        InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, interfaceC5755nM2).getKotlinType();
        p.f(kotlinType);
        throw new CannotTransformContentToTypeException(kotlinType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r11 == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object receiveText(io.ktor.server.application.ApplicationCall r10, e9.InterfaceC4014c<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.C43931
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveText$1 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.C43931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveText$1 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveText$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 2
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r6 = io.ktor.utils.io.ByteReadChannel.class
            if (r2 == 0) goto L43
            if (r2 == r3) goto L3b
            if (r2 != r5) goto L33
            java.lang.Object r10 = r0.L$0
            java.nio.charset.Charset r10 = (java.nio.charset.Charset) r10
            kotlin.C4849c.b(r11)
            goto L81
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            java.lang.Object r10 = r0.L$0
            java.nio.charset.Charset r10 = (java.nio.charset.Charset) r10
            kotlin.C4849c.b(r11)
            goto L72
        L43:
            kotlin.C4849c.b(r11)
            io.ktor.server.request.ApplicationRequest r11 = r10.getRequest()     // Catch: io.ktor.http.BadContentTypeFormatException -> L53
            java.nio.charset.Charset r11 = io.ktor.server.request.ApplicationRequestPropertiesKt.contentCharset(r11)     // Catch: io.ktor.http.BadContentTypeFormatException -> L53
            if (r11 != 0) goto L55
            java.nio.charset.Charset r11 = La.C0953c.UTF_8     // Catch: io.ktor.http.BadContentTypeFormatException -> L53
            goto L55
        L53:
            r11 = move-exception
            goto La3
        L55:
            w9.d r2 = kotlin.jvm.internal.t.b(r6)
            w9.n r7 = kotlin.jvm.internal.t.m(r6)     // Catch: java.lang.Throwable -> L5e
            goto L5f
        L5e:
            r7 = r4
        L5f:
            io.ktor.util.reflect.TypeInfo r8 = new io.ktor.util.reflect.TypeInfo
            r8.<init>(r2, r7)
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r10 = r10.receiveNullable(r8, r0)
            if (r10 != r1) goto L6f
            goto L80
        L6f:
            r9 = r11
            r11 = r10
            r10 = r9
        L72:
            if (r11 == 0) goto L89
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r11, r0)
            if (r11 != r1) goto L81
        L80:
            return r1
        L81:
            fb.v r11 = (fb.v) r11
            r0 = 0
            java.lang.String r10 = io.ktor.utils.io.core.StringsKt.readText$default(r11, r10, r0, r5, r4)
            return r10
        L89:
            w9.d r10 = kotlin.jvm.internal.t.b(r6)
            w9.n r4 = kotlin.jvm.internal.t.m(r6)     // Catch: java.lang.Throwable -> L91
        L91:
            io.ktor.util.reflect.TypeInfo r11 = new io.ktor.util.reflect.TypeInfo
            r11.<init>(r10, r4)
            w9.n r10 = r11.getKotlinType()
            kotlin.jvm.internal.p.f(r10)
            io.ktor.server.plugins.CannotTransformContentToTypeException r11 = new io.ktor.server.plugins.CannotTransformContentToTypeException
            r11.<init>(r10)
            throw r11
        La3:
            io.ktor.server.plugins.BadRequestException r0 = new io.ktor.server.plugins.BadRequestException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Illegal Content-Type format: "
            r1.append(r2)
            io.ktor.server.request.ApplicationRequest r10 = r10.getRequest()
            io.ktor.http.Headers r10 = r10.getHeaders()
            io.ktor.http.HttpHeaders r2 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r2 = r2.getContentType()
            java.lang.String r10 = r10.get(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receiveText(io.ktor.server.application.ApplicationCall, e9.c):java.lang.Object");
    }

    private static final Object receiveText$$forInline(ApplicationCall applicationCall, InterfaceC4014c<? super String> interfaceC4014c) throws Throwable {
        InterfaceC5755n interfaceC5755nM;
        try {
            Charset charsetContentCharset = ApplicationRequestPropertiesKt.contentCharset(applicationCall.getRequest());
            if (charsetContentCharset == null) {
                charsetContentCharset = C0953c.UTF_8;
            }
            InterfaceC5745d interfaceC5745dB = t.b(ByteReadChannel.class);
            InterfaceC5755n interfaceC5755nM2 = null;
            try {
                interfaceC5755nM = t.m(ByteReadChannel.class);
            } catch (Throwable unused) {
                interfaceC5755nM = null;
            }
            TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
            n.c(0);
            Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
            n.c(1);
            if (objReceiveNullable != null) {
                n.c(0);
                Object remaining = ByteReadChannelOperationsKt.readRemaining((ByteReadChannel) objReceiveNullable, interfaceC4014c);
                n.c(1);
                return StringsKt.readText$default((v) remaining, charsetContentCharset, 0, 2, null);
            }
            InterfaceC5745d interfaceC5745dB2 = t.b(ByteReadChannel.class);
            try {
                interfaceC5755nM2 = t.m(ByteReadChannel.class);
            } catch (Throwable unused2) {
            }
            InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, interfaceC5755nM2).getKotlinType();
            p.f(kotlinType);
            throw new CannotTransformContentToTypeException(kotlinType);
        } catch (BadContentTypeFormatException e10) {
            throw new BadRequestException("Illegal Content-Type format: " + applicationCall.getRequest().getHeaders().get(HttpHeaders.INSTANCE.getContentType()), e10);
        }
    }

    public static final void setFormFieldLimit(ApplicationCall applicationCall, long j10) {
        p.i(applicationCall, "<this>");
        applicationCall.getAttributes().put(FORM_FIELD_LIMIT, Long.valueOf(j10));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object receive(io.ktor.server.application.ApplicationCall r4, io.ktor.util.reflect.TypeInfo r5, e9.InterfaceC4014c<? super T> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$3 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$3 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receive$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r6)
            r0.label = r3
            java.lang.Object r6 = r4.receiveNullable(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            kotlin.jvm.internal.p.f(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receive(io.ktor.server.application.ApplicationCall, io.ktor.util.reflect.TypeInfo, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object receiveOrNull(io.ktor.server.application.ApplicationCall r4, w9.InterfaceC5745d<T> r5, e9.InterfaceC4014c<? super T> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.server.request.ApplicationReceiveFunctionsKt.C43913
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$3 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsKt.C43913) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$3 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsKt$receiveOrNull$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            io.ktor.server.application.ApplicationCall r4 = (io.ktor.server.application.ApplicationCall) r4
            kotlin.C4849c.b(r6)     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            return r6
        L2d:
            r5 = move-exception
            goto L46
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r6)
            r0.L$0 = r4     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            r0.label = r3     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            java.lang.Object r4 = receive(r4, r5, r0)     // Catch: io.ktor.server.plugins.ContentTransformationException -> L2d
            if (r4 != r1) goto L45
            return r1
        L45:
            return r4
        L46:
            io.ktor.server.application.Application r4 = r4.getApplication()
            vc.c r4 = io.ktor.server.application.ApplicationKt.getLog(r4)
            java.lang.String r6 = "Conversion failed, null returned"
            r4.debug(r6, r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsKt.receiveOrNull(io.ktor.server.application.ApplicationCall, w9.d, e9.c):java.lang.Object");
    }

    public static final /* synthetic */ <T> Object receive(ApplicationCall applicationCall, InterfaceC4014c<? super T> interfaceC4014c) throws CannotTransformContentToTypeException {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        if (objReceiveNullable != null) {
            return objReceiveNullable;
        }
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB2 = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused2) {
        }
        InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, null).getKotlinType();
        p.f(kotlinType);
        throw new CannotTransformContentToTypeException(kotlinType);
    }

    public static final /* synthetic */ <T> Object receiveOrNull(ApplicationCall applicationCall, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objReceiveOrNull = receiveOrNull(applicationCall, typeInfo, interfaceC4014c);
        n.c(1);
        return objReceiveOrNull;
    }
}
