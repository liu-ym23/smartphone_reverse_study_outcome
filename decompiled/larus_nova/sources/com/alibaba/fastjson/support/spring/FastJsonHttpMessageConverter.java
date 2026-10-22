package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;

/* JADX INFO: loaded from: classes28.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = null;
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig;
    protected SerializerFeature[] features;
    protected SerializeFilter[] filters;
    private boolean setLengthError;

    public static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        private Spring4TypeResolvableHelper() {
        }

        public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        static {
            INVOKESTATIC_com_alibaba_fastjson_support_spring_FastJsonHttpMessageConverter$Spring4TypeResolvableHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("org.springframework.core.ResolvableType");     // Catch: ClassNotFoundException -> L4
            hasClazzResolvableType = true;     // Catch: ClassNotFoundException -> L4
            return;
        L4:
            hasClazzResolvableType = false;
        }

        public static /* synthetic */ boolean access$000() {
            return isSupport();
        }

        private static boolean isSupport() {
            return hasClazzResolvableType;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_alibaba_fastjson_support_spring_FastJsonHttpMessageConverter$Spring4TypeResolvableHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r103 = access$001(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$001(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public static /* synthetic */ Type access$100(Type r100, Class r101) {
            return getType(r100, r101);
        }

        private static Type getType(Type r100, Class<?> r101) {
            if (r101 == null) goto L30;
            ResolvableType r102 = ResolvableType.forType(r100);
            if ((r100 instanceof TypeVariable) == false) goto L10;
            ResolvableType r103 = resolveVariable((TypeVariable) r100, ResolvableType.forClass(r101));
            if (r103 != ResolvableType.NONE) goto L8;
            return r100;
        L8:
            return r103.resolve();
        L10:
            if ((r100 instanceof ParameterizedType) == true) goto L12;
            return r100;
        L12:
            if (r102.hasUnresolvableGenerics() == false) goto L33;
            ParameterizedType r104 = (ParameterizedType) r100;
            Class[] r105 = new Class[r104.getActualTypeArguments().length];
            Type[] r106 = r104.getActualTypeArguments();
            int r107 = 0;
        L15:
            if (r107 >= r106.length) goto L25;
            Type r108 = r106[r107];
            if ((r108 instanceof TypeVariable) == false) goto L22;
            ResolvableType r109 = resolveVariable((TypeVariable) r108, ResolvableType.forClass(r101));
            if (r109 == ResolvableType.NONE) goto L21;
            r105[r107] = r109.resolve();
        L23:
            r107 = r107 + 1;
            goto L15
        L21:
            r105[r107] = ResolvableType.forType(r108).resolve();
            goto L23
        L22:
            r105[r107] = ResolvableType.forType(r108).resolve();
            goto L23
        L25:
            return ResolvableType.forClassWithGenerics(r102.getRawClass(), r105).getType();
        L33:
            return r100;
        L30:
            return r100;
        }

        private static ResolvableType resolveVariable(TypeVariable<?> r100, ResolvableType r101) {
            if (r101.hasGenerics() == false) goto L7;
            ResolvableType r102 = ResolvableType.forType(r100, r101);
            if (r102.resolve() == null) goto L7;
            return r102;
        L7:
            ResolvableType r103 = r101.getSuperType();
            if (r103 == ResolvableType.NONE) goto L12;
            ResolvableType r104 = resolveVariable(r100, r103);
            if (r104.resolve() == null) goto L12;
            return r104;
        L12:
            ResolvableType[] r105 = r101.getInterfaces();
            int r106 = r105.length;
            int r107 = 0;
        L13:
            if (r107 >= r106) goto L19;
            ResolvableType r108 = resolveVariable(r100, r105[r107]);
            if (r108.resolve() != null) goto L16;
            r107 = r107 + 1;
            goto L13
        L16:
            return r108;
        L19:
            return ResolvableType.NONE;
        }
    }

    public boolean supports(Class<?> r100) {
        return true;
    }

    static {
        APPLICATION_JAVASCRIPT = new MediaType("application", "javascript");
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.setLengthError = false;
        this.fastJsonConfig = new FastJsonConfig();
    }

    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    private Object strangeCodeForJackson(Object r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if ("com.fasterxml.jackson.databind.node.ObjectNode".equals(r100.getClass().getName()) == true) goto L6;
        return r100;
    L6:
        return r100.toString();
    }

    public void addSerializeFilter(SerializeFilter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = this.fastJsonConfig.getSerializeFilters().length;
        int r102 = r101 + 1;
        SerializeFilter[] r103 = new SerializeFilter[r102];
        System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, r103, 0, r101);
        r103[r102 - 1] = r100;
        this.fastJsonConfig.setSerializeFilters(r103);
    }

    public void setCharset(Charset r100) {
        this.fastJsonConfig.setCharset(r100);
    }

    public void setDateFormat(String r100) {
        this.fastJsonConfig.setDateFormat(r100);
    }

    public void setFastJsonConfig(FastJsonConfig r100) {
        this.fastJsonConfig = r100;
    }

    public void setFeatures(SerializerFeature... r100) {
        this.fastJsonConfig.setSerializerFeatures(r100);
    }

    public void setFilters(SerializeFilter... r100) {
        this.fastJsonConfig.setSerializeFilters(r100);
    }

    private Object readType(Type r100, HttpInputMessage r101) {
        return JSON.parseObject(r101.getBody(), this.fastJsonConfig.getCharset(), r100, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
    L7:
        e = move-exception;
        throw new HttpMessageNotReadableException("JSON parse error: " + e.getMessage(), e);
    L4:
        e = move-exception;
        throw new HttpMessageNotReadableException("I/O error while reading input message", e);
    }

    public Type getType(Type r100, Class<?> r101) {
        if (Spring4TypeResolvableHelper.access$000() == true) goto L5;
        return r100;
    L5:
        return Spring4TypeResolvableHelper.access$100(r100, r101);
    }

    public Object readInternal(Class<?> r100, HttpInputMessage r101) throws IOException, HttpMessageNotReadableException {
        return readType(getType(r100, null), r101);
    }

    public void writeInternal(Object r110, HttpOutputMessage r111) throws IOException, HttpMessageNotWritableException {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        HttpHeaders r112 = r111.getHeaders();     // Catch: Throwable -> L29 JSONException -> L31
        ArrayList r101 = new ArrayList(Arrays.asList(this.fastJsonConfig.getSerializeFilters()));     // Catch: Throwable -> L29 JSONException -> L31
        Object r113 = strangeCodeForJackson(r110);     // Catch: Throwable -> L29 JSONException -> L31
        if ((r113 instanceof FastJsonContainer) == false) goto L6;
        FastJsonContainer r114 = (FastJsonContainer) r113;     // Catch: Throwable -> L29 JSONException -> L31
        r101.addAll(r114.getFilters().getFilters());     // Catch: Throwable -> L29 JSONException -> L31
        r113 = r114.getValue();     // Catch: Throwable -> L29 JSONException -> L31
    L6:
        Object r102 = r113;
        if ((r102 instanceof MappingFastJsonValue) == false) goto L12;
        if (StringUtils.isEmpty(((MappingFastJsonValue) r102).getJsonpFunction()) == false) goto L13;
    L14:
        boolean r115 = false;
    L15:
        int r103 = JSON.writeJSONStringWithFastJsonConfig(r100, this.fastJsonConfig.getCharset(), r102, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) r101.toArray(new SerializeFilter[r101.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());     // Catch: Throwable -> L29 JSONException -> L31
        if (r115 == false) goto L19;
        r112.setContentType(APPLICATION_JAVASCRIPT);     // Catch: Throwable -> L29 JSONException -> L31
    L19:
        if (this.fastJsonConfig.isWriteContentLength() == true) goto L21;
    L26:
        r100.writeTo(r111.getBody());     // Catch: Throwable -> L29 JSONException -> L31
        r100.close();
        return;
    L21:
        if (this.setLengthError == true) goto L26;
        r112.setContentLength(r103);     // Catch: UnsupportedOperationException -> L25 Throwable -> L29 JSONException -> L31
    L25:
        this.setLengthError = true;     // Catch: Throwable -> L29 JSONException -> L31
    L13:
        r115 = true;
        goto L15
    L12:
        if ((r102 instanceof JSONPObject) == false) goto L14;
    L29:
        th = move-exception;
        r100.close();
        throw th;
    L31:
        e = move-exception;
        throw new HttpMessageNotWritableException("Could not write JSON: " + e.getMessage(), e);     // Catch: Throwable -> L29
    }

    public boolean canRead(Type r100, Class<?> r101, MediaType r102) {
        return super.canRead(r101, r102);
    }

    public boolean canWrite(Type r100, Class<?> r101, MediaType r102) {
        return super.canWrite(r101, r102);
    }

    public Object read(Type r100, Class<?> r101, HttpInputMessage r102) throws IOException, HttpMessageNotReadableException {
        return readType(getType(r100, r101), r102);
    }

    public void write(Object r100, Type r101, MediaType r102, HttpOutputMessage r103) throws IOException, HttpMessageNotWritableException {
        super.write(r100, r102, r103);
    }
}
