package io.ktor.util.converters;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0016BO\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u001c\u0010\b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004\u0012\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R*\u0010\b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R*\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/util/converters/DelegatingConversionService;", "Lio/ktor/util/converters/ConversionService;", "Lw9/d;", "klass", "Lkotlin/Function1;", "", "", "", "decoder", "encoder", "<init>", "(Lw9/d;Lp9/l;Lp9/l;)V", "values", "Lio/ktor/util/reflect/TypeInfo;", "type", "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", UxipConstants.f30680s, "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "Lw9/d;", "Lp9/l;", "Configuration", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DelegatingConversionService implements ConversionService {
    private final InterfaceC5074l<List<String>, Object> decoder;
    private final InterfaceC5074l<Object, List<String>> encoder;
    private final InterfaceC5745d<?> klass;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\b\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\u000e\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\rR6\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lio/ktor/util/converters/DelegatingConversionService$Configuration;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "klass", "<init>", "(Lw9/d;)V", "Lkotlin/Function1;", "", "", "converter", "LY8/t;", "decode", "(Lp9/l;)V", "encode", "Lw9/d;", "getKlass$ktor_utils", "()Lw9/d;", "decoder", "Lp9/l;", "getDecoder$ktor_utils", "()Lp9/l;", "setDecoder$ktor_utils", "encoder", "getEncoder$ktor_utils", "setEncoder$ktor_utils", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Configuration<T> {
        private InterfaceC5074l<? super List<String>, ? extends T> decoder;
        private InterfaceC5074l<? super T, ? extends List<String>> encoder;
        private final InterfaceC5745d<T> klass;

        public Configuration(InterfaceC5745d<T> klass) {
            p.i(klass, "klass");
            this.klass = klass;
        }

        public final void decode(InterfaceC5074l<? super List<String>, ? extends T> converter) {
            p.i(converter, "converter");
            if (this.decoder == null) {
                this.decoder = converter;
                return;
            }
            throw new IllegalStateException("Decoder has already been set for type '" + this.klass + '\'');
        }

        public final void encode(InterfaceC5074l<? super T, ? extends List<String>> converter) {
            p.i(converter, "converter");
            if (this.encoder == null) {
                this.encoder = converter;
                return;
            }
            throw new IllegalStateException("Encoder has already been set for type '" + this.klass + '\'');
        }

        public final InterfaceC5074l<List<String>, T> getDecoder$ktor_utils() {
            return this.decoder;
        }

        public final InterfaceC5074l<T, List<String>> getEncoder$ktor_utils() {
            return this.encoder;
        }

        public final InterfaceC5745d<T> getKlass$ktor_utils() {
            return this.klass;
        }

        public final void setDecoder$ktor_utils(InterfaceC5074l<? super List<String>, ? extends T> interfaceC5074l) {
            this.decoder = interfaceC5074l;
        }

        public final void setEncoder$ktor_utils(InterfaceC5074l<? super T, ? extends List<String>> interfaceC5074l) {
            this.encoder = interfaceC5074l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingConversionService(InterfaceC5745d<?> klass, InterfaceC5074l<? super List<String>, ? extends Object> interfaceC5074l, InterfaceC5074l<Object, ? extends List<String>> interfaceC5074l2) {
        p.i(klass, "klass");
        this.klass = klass;
        this.decoder = interfaceC5074l;
        this.encoder = interfaceC5074l2;
    }

    @Override // io.ktor.util.converters.ConversionService
    public Object fromValues(List<String> values, TypeInfo type) {
        p.i(values, "values");
        p.i(type, "type");
        InterfaceC5074l<List<String>, Object> interfaceC5074l = this.decoder;
        if (interfaceC5074l != null) {
            return interfaceC5074l.invoke(values);
        }
        throw new IllegalStateException("Decoder was not specified for type '" + this.klass + '\'');
    }

    @Override // io.ktor.util.converters.ConversionService
    public List<String> toValues(Object value) {
        InterfaceC5074l<Object, List<String>> interfaceC5074l = this.encoder;
        if (interfaceC5074l != null) {
            return interfaceC5074l.invoke(value);
        }
        throw new IllegalStateException("Encoder was not specified for type '" + this.klass + '\'');
    }
}
