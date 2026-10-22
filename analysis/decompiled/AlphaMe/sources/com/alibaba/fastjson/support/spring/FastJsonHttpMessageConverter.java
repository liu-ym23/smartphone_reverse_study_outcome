package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.stepos.activeview.utils.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* loaded from: classes.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = new MediaType("application", "javascript");
    private static final byte[] JSONP_FUNCTION_PREFIX_BYTES;
    private static final byte[] JSONP_FUNCTION_SUFFIX_BYTES;
    private Charset charset;

    @Deprecated
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig;

    @Deprecated
    protected SerializerFeature[] features;

    @Deprecated
    protected SerializeFilter[] filters;

    static {
        Charset charset = IOUtils.UTF8;
        JSONP_FUNCTION_PREFIX_BYTES = "/**/".getBytes(charset);
        JSONP_FUNCTION_SUFFIX_BYTES = ");".getBytes(charset);
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        this.charset = Charset.forName(Constants.UTF_8_CODE);
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.http.converter.HttpMessageNotReadableException */
    private Object readType(Type type, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try {
            return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
        } catch (JSONException e4) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e4.getMessage(), e4);
        } catch (IOException e5) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e5);
        }
    }

    private ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
        if (resolvableType.hasGenerics()) {
            ResolvableType resolvableTypeForType = ResolvableType.forType(typeVariable, resolvableType);
            if (resolvableTypeForType.resolve() != null) {
                return resolvableTypeForType;
            }
        }
        ResolvableType superType = resolvableType.getSuperType();
        if (superType != ResolvableType.NONE) {
            ResolvableType resolvableTypeResolveVariable = resolveVariable(typeVariable, superType);
            if (resolvableTypeResolveVariable.resolve() != null) {
                return resolvableTypeResolveVariable;
            }
        }
        for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
            ResolvableType resolvableTypeResolveVariable2 = resolveVariable(typeVariable, resolvableType2);
            if (resolvableTypeResolveVariable2.resolve() != null) {
                return resolvableTypeResolveVariable2;
            }
        }
        return ResolvableType.NONE;
    }

    private Object strangeCodeForJackson(Object obj) {
        return (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString();
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        int length = this.fastJsonConfig.getSerializeFilters().length;
        SerializeFilter[] serializeFilterArr = new SerializeFilter[length + 1];
        System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
        serializeFilterArr[length] = serializeFilter;
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    public Type getType(Type type, Class<?> cls) {
        if (cls != null) {
            ResolvableType resolvableTypeForType = ResolvableType.forType(type);
            if (type instanceof TypeVariable) {
                ResolvableType resolvableTypeResolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                if (resolvableTypeResolveVariable != ResolvableType.NONE) {
                    return resolvableTypeResolveVariable.resolve();
                }
            } else if ((type instanceof ParameterizedType) && resolvableTypeForType.hasUnresolvableGenerics()) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i4 = 0; i4 < actualTypeArguments.length; i4++) {
                    Type type2 = actualTypeArguments[i4];
                    if (type2 instanceof TypeVariable) {
                        ResolvableType resolvableTypeResolveVariable2 = resolveVariable((TypeVariable) type2, ResolvableType.forClass(cls));
                        if (resolvableTypeResolveVariable2 != ResolvableType.NONE) {
                            clsArr[i4] = resolvableTypeResolveVariable2.resolve();
                        } else {
                            clsArr[i4] = ResolvableType.forType(type2).resolve();
                        }
                    } else {
                        clsArr[i4] = ResolvableType.forType(type2).resolve();
                    }
                }
                return ResolvableType.forClassWithGenerics(resolvableTypeForType.getRawClass(), clsArr).getType();
            }
        }
        return type;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean supports(Class<?> cls) {
        return true;
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    public void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                HttpHeaders headers = httpOutputMessage.getHeaders();
                ArrayList arrayList = new ArrayList(Arrays.asList(this.fastJsonConfig.getSerializeFilters()));
                Object objStrangeCodeForJackson = strangeCodeForJackson(obj);
                if (objStrangeCodeForJackson instanceof FastJsonContainer) {
                    FastJsonContainer fastJsonContainer = (FastJsonContainer) objStrangeCodeForJackson;
                    arrayList.addAll(fastJsonContainer.getFilters().getFilters());
                    objStrangeCodeForJackson = fastJsonContainer.getValue();
                }
                boolean z4 = true;
                if (objStrangeCodeForJackson instanceof MappingFastJsonValue) {
                    objStrangeCodeForJackson = ((MappingFastJsonValue) objStrangeCodeForJackson).getValue();
                } else if (!(objStrangeCodeForJackson instanceof JSONPObject)) {
                    z4 = false;
                }
                boolean z5 = z4;
                int iWritePrefix = writePrefix(byteArrayOutputStream, obj) + JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), objStrangeCodeForJackson, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures()) + writeSuffix(byteArrayOutputStream, obj);
                if (z5) {
                    headers.setContentType(APPLICATION_JAVASCRIPT);
                }
                if (this.fastJsonConfig.isWriteContentLength()) {
                    headers.setContentLength(iWritePrefix);
                }
                byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                byteArrayOutputStream.close();
            } catch (JSONException e4) {
                throw new HttpMessageNotWritableException("Could not write JSON: " + e4.getMessage(), e4);
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public int writePrefix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        String jsonpFunction = obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null;
        if (jsonpFunction == null) {
            return 0;
        }
        byte[] bArr = JSONP_FUNCTION_PREFIX_BYTES;
        byteArrayOutputStream.write(bArr);
        byte[] bytes = jsonpFunction.concat("(").getBytes(IOUtils.UTF8);
        byteArrayOutputStream.write(bytes);
        return bArr.length + bytes.length;
    }

    public int writeSuffix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        if ((obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null) == null) {
            return 0;
        }
        byte[] bArr = JSONP_FUNCTION_SUFFIX_BYTES;
        byteArrayOutputStream.write(bArr);
        return bArr.length;
    }
}
