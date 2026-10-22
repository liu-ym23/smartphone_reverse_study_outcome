package com.bytedance.rpc;

import com.bytedance.rpc.internal.MapBuilder;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.ByteType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcDataBuilder {
    private List<ByteType> mData;
    private Map<String, String> mFields;
    private Map<String, File> mFiles;
    private Map<String, String> mHeaders;
    private Map<String, String> mQueries;

    /* JADX INFO: renamed from: com.bytedance.rpc.RpcDataBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class SerializerData {
        private List<ByteType> mData;
        private Map<String, String> mFields;
        private Map<String, File> mFiles;
        private Map<String, String> mHeaders;
        private Map<String, String> mQueries;

        /* synthetic */ SerializerData(RpcDataBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Map access$000(SerializerData r0) {
            return r0.mHeaders;
        }

        static /* synthetic */ Map access$100(SerializerData r0) {
            return r0.mQueries;
        }

        static /* synthetic */ List access$200(SerializerData r0) {
            return r0.mData;
        }

        static /* synthetic */ Map access$300(SerializerData r0) {
            return r0.mFields;
        }

        static /* synthetic */ Map access$400(SerializerData r0) {
            return r0.mFiles;
        }

        private SerializerData(RpcDataBuilder r2) {
            this.mHeaders = RpcDataBuilder.access$600(r2);
            this.mQueries = RpcDataBuilder.access$700(r2);
            this.mData = RpcDataBuilder.access$800(r2);
            this.mFields = RpcDataBuilder.access$900(r2);
            this.mFiles = RpcDataBuilder.access$1000(r2);
        }

        public Map<String, String> getHeaders() {
            return this.mHeaders;
        }

        public Map<String, String> getQueries() {
            return this.mQueries;
        }

        public List<ByteType> getData() {
            return this.mData;
        }

        public Map<String, String> getFields() {
            return this.mFields;
        }

        public Map<String, File> getFiles() {
            return this.mFiles;
        }

        public boolean isMutiData() {
            if (this.mFiles.size() <= 0) goto L5;
            return true;
        L5:
            if ((this.mFields.size() + this.mData.size()) <= 1) goto L7;
            return true;
        L7:
            if (this.mData.size() != 1) goto L12;
            if (this.mData.get(0).getContentType().equals("multipart/form-data") == false) goto L12;
            return true;
        L12:
            return false;
        }

        public boolean isFormData() {
            if (this.mFields.size() > 0) goto L5;
            return false;
        L5:
            if (this.mFiles.isEmpty() == true) goto L7;
            return false;
        L7:
            if (this.mData.isEmpty() == true) goto L13;
            if (this.mData.size() == 1) goto L11;
            return false;
        L11:
            if (this.mData.get(0).getContentLength() <= 0) goto L13;
            return false;
        L13:
            return true;
        }

        public RpcDataBuilder toBuilder() {
            return new RpcDataBuilder(this, null);
        }

        public void clear() {
            this.mHeaders.clear();
            this.mQueries.clear();
            this.mData.clear();
            this.mFields.clear();
            this.mFiles.clear();
        }

        public String toString() {
            return "SerializerData{mHeaders=" + this.mHeaders + ", mQueries=" + this.mQueries + ", mData=" + this.mData + ", mFields=" + this.mFields + ", mFiles=" + this.mFiles + '}';
        }
    }

    /* synthetic */ RpcDataBuilder(SerializerData r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Map access$1000(RpcDataBuilder r0) {
        return r0.mFiles;
    }

    static /* synthetic */ Map access$600(RpcDataBuilder r0) {
        return r0.mHeaders;
    }

    static /* synthetic */ Map access$700(RpcDataBuilder r0) {
        return r0.mQueries;
    }

    static /* synthetic */ List access$800(RpcDataBuilder r0) {
        return r0.mData;
    }

    static /* synthetic */ Map access$900(RpcDataBuilder r0) {
        return r0.mFields;
    }

    private RpcDataBuilder(SerializerData r3) {
        this.mHeaders = new HashMap(SerializerData.access$000(r3));
        this.mQueries = new HashMap(SerializerData.access$100(r3));
        this.mData = new ArrayList(SerializerData.access$200(r3));
        this.mFields = new HashMap(SerializerData.access$300(r3));
        this.mFiles = new HashMap(SerializerData.access$400(r3));
    }

    public RpcDataBuilder() {
        this.mHeaders = new HashMap(4);
        this.mQueries = new HashMap(4);
        this.mData = new ArrayList(2);
        this.mFields = new HashMap(4);
        this.mFiles = new HashMap(4);
    }

    public RpcDataBuilder setDataType(byte[] r2, String r3) {
        this.mData.clear();
        return addDataType(r2, r3, null);
    }

    public RpcDataBuilder addDataType(byte[] r2, String r3, String r4) {
        return addDataType(r2, r3, r4, null);
    }

    public RpcDataBuilder addDataType(byte[] r3, String r4, String r5, String r6) {
        this.mData.add(new ByteType(r3, r4, r5, r6));
        return this;
    }

    public RpcDataBuilder setHeaders(Map<String, String> r2) {
        if (r2 != null) goto L4;
    L7:
        this.mHeaders.clear();
    L8:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L7;
        this.mHeaders = r2;
        goto L8
    }

    public RpcDataBuilder addHeader(String r2, String r3) {
        MapBuilder.put(this.mHeaders, r2, r3);
        return this;
    }

    public RpcDataBuilder addHeaders(Map<String, String> r2) {
        MapBuilder.put(this.mHeaders, r2);
        return this;
    }

    public RpcDataBuilder setQueries(Map<String, String> r2) {
        if (r2 != null) goto L4;
    L7:
        this.mQueries.clear();
    L8:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L7;
        this.mQueries = r2;
        goto L8
    }

    public RpcDataBuilder addQuery(String r2, String r3) {
        MapBuilder.put(this.mQueries, r2, r3);
        return this;
    }

    public RpcDataBuilder addQueries(Map<String, String> r2) {
        MapBuilder.put(this.mQueries, r2);
        return this;
    }

    public RpcDataBuilder setFields(Map<String, String> r2) {
        if (r2 != null) goto L4;
    L7:
        this.mFields.clear();
    L8:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L7;
        this.mFields = r2;
        goto L8
    }

    public RpcDataBuilder addField(String r2, String r3) {
        MapBuilder.put(this.mFields, r2, r3);
        return this;
    }

    public RpcDataBuilder addFields(Map<String, String> r2) {
        MapBuilder.put(this.mFields, r2);
        return this;
    }

    public RpcDataBuilder setFiles(Map<String, File> r2) {
        if (r2 != null) goto L4;
    L7:
        this.mFiles.clear();
    L8:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L7;
        this.mFiles = r2;
        goto L8
    }

    public RpcDataBuilder addFile(String r2, File r3) {
        if (RpcUtils.isVisible(r2) == false) goto L7;
        if (r3 != null) goto L6;
        this.mFiles.remove(r2);
        goto L7
    L6:
        this.mFiles.put(r2, r3);
    L7:
        return this;
    }

    public RpcDataBuilder addFiles(Map<String, File> r2) {
        if (r2 != null) goto L4;
    L6:
        return this;
    L4:
        if (r2.size() <= 0) goto L6;
        this.mFiles.putAll(r2);
        goto L6
    }

    public SerializerData build() {
        return new SerializerData(this, null);
    }

    RpcDataBuilder setDataType(ByteType r2) {
        this.mData.clear();
        if (r2 == null) goto L5;
        this.mData.add(r2);
    L5:
        return this;
    }

    RpcDataBuilder apply(SerializerData r3) {
        addHeaders(SerializerData.access$000(r3));
        addQueries(SerializerData.access$100(r3));
        addFiles(SerializerData.access$400(r3));
        addFields(SerializerData.access$300(r3));
        if (SerializerData.access$200(r3).size() <= 1) goto L5;
    L8:
        this.mData.addAll(SerializerData.access$200(r3));
    L9:
        return this;
    L5:
        if (SerializerData.access$200(r3).size() != 1) goto L9;
        if (((ByteType) SerializerData.access$200(r3).get(0)).getContentLength() <= 0) goto L9;
        goto L8
    }

    Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    Map<String, String> getQueries() {
        return this.mQueries;
    }

    List<ByteType> getData() {
        return this.mData;
    }

    Map<String, String> getFields() {
        return this.mFields;
    }

    Map<String, File> getFiles() {
        return this.mFiles;
    }
}
