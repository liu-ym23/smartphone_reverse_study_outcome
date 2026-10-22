package com.stepos.core.data;

import Y8.j;
import Y8.t;
import Z8.F;
import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.core.data.ContentParams;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 <2\u00020\u0001:\u0003=><B\u001d\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\f¢\u0006\u0004\b+\u0010,J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-¢\u0006\u0004\b.\u0010/J\r\u00101\u001a\u000200¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\f¢\u0006\u0004\b3\u0010,J\u001f\u00106\u001a\u0002052\u0006\u0010\t\u001a\u00020\b2\u0006\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\fH\u0016¢\u0006\u0004\b8\u0010,J\u000f\u00109\u001a\u00020\u0003H\u0016¢\u0006\u0004\b9\u0010:R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010;¨\u0006?"}, d2 = {"Lcom/stepos/core/data/ContentParams;", "Landroid/os/Parcelable;", "", "", "Lcom/stepos/core/data/ContentParams$ParamValue;", "params", "<init>", "(Ljava/util/Map;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "key", "", "default", "getInt", "(Ljava/lang/String;I)I", "", "getLong", "(Ljava/lang/String;J)J", "", "getFloat", "(Ljava/lang/String;F)F", "", "getDouble", "(Ljava/lang/String;D)D", "", "getBoolean", "(Ljava/lang/String;Z)Z", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "getIntArray", "(Ljava/lang/String;)[I", "", "getFloatArray", "(Ljava/lang/String;)[F", "containsKey", "(Ljava/lang/String;)Z", UxipConstants.f30680s, "withInt", "(Ljava/lang/String;I)Lcom/stepos/core/data/ContentParams;", "isEmpty", "()Z", ContentDisposition.Parameters.Size, "()I", "", "keys", "()Ljava/util/Set;", "", "toByteArray", "()[B", "calculateByteSize", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "Companion", "ParamValue", "Builder", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentParams implements Parcelable {
    private static final byte TYPE_BOOLEAN = 4;
    private static final byte TYPE_DOUBLE = 3;
    private static final byte TYPE_FLOAT = 2;
    private static final byte TYPE_FLOAT_ARRAY = 7;
    private static final byte TYPE_INT = 0;
    private static final byte TYPE_INT_ARRAY = 6;
    private static final byte TYPE_LONG = 1;
    private static final byte TYPE_STRING = 5;
    private final Map<String, ParamValue> params;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ContentParams> CREATOR = new Parcelable.Creator<ContentParams>() { // from class: com.stepos.core.data.ContentParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentParams createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ContentParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentParams[] newArray(int size) {
            return new ContentParams[size];
        }
    };

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stepos/core/data/ContentParams$Builder;", "", "<init>", "()V", "params", "", "", "Lcom/stepos/core/data/ContentParams$ParamValue;", "putInt", "key", UxipConstants.f30680s, "", "putLong", "", "putFloat", "", "putDouble", "", "putBoolean", "", "putString", "putIntArray", "", "putFloatArray", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/core/data/ContentParams;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private final Map<String, ParamValue> params = new LinkedHashMap();

        public final ContentParams build() {
            return new ContentParams(a.A(this.params), null);
        }

        public final Builder putBoolean(String key, boolean value) {
            p.i(key, "key");
            this.params.put(key, new ParamValue.BooleanValue(value));
            return this;
        }

        public final Builder putDouble(String key, double value) {
            p.i(key, "key");
            this.params.put(key, new ParamValue.DoubleValue(value));
            return this;
        }

        public final Builder putFloat(String key, float value) {
            p.i(key, "key");
            this.params.put(key, new ParamValue.FloatValue(value));
            return this;
        }

        public final Builder putFloatArray(String key, float[] value) {
            p.i(key, "key");
            p.i(value, "value");
            this.params.put(key, new ParamValue.FloatArrayValue(value));
            return this;
        }

        public final Builder putInt(String key, int value) {
            p.i(key, "key");
            this.params.put(key, new ParamValue.IntValue(value));
            return this;
        }

        public final Builder putIntArray(String key, int[] value) {
            p.i(key, "key");
            p.i(value, "value");
            this.params.put(key, new ParamValue.IntArrayValue(value));
            return this;
        }

        public final Builder putLong(String key, long value) {
            p.i(key, "key");
            this.params.put(key, new ParamValue.LongValue(value));
            return this;
        }

        public final Builder putString(String key, String value) {
            p.i(key, "key");
            p.i(value, "value");
            this.params.put(key, new ParamValue.StringValue(value));
            return this;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stepos/core/data/ContentParams$Companion;", "", "<init>", "()V", "TYPE_INT", "", "TYPE_LONG", "TYPE_FLOAT", "TYPE_DOUBLE", "TYPE_BOOLEAN", "TYPE_STRING", "TYPE_INT_ARRAY", "TYPE_FLOAT_ARRAY", "fromByteArray", "Lcom/stepos/core/data/ContentParams;", SingleFileBundle.KEY_BYTES, "", "readParamsFromParcel", "", "", "Lcom/stepos/core/data/ContentParams$ParamValue;", "parcel", "Landroid/os/Parcel;", "empty", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, ParamValue> readParamsFromParcel(Parcel parcel) {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return fromByteArray(bArr).params;
        }

        public final ContentParams empty() {
            return new ContentParams(a.i(), null);
        }

        public final ContentParams fromByteArray(byte[] bytes) {
            ParamValue floatArrayValue;
            p.i(bytes, "bytes");
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = byteBufferOrder.getInt();
            for (int i11 = 0; i11 < i10; i11++) {
                byte b10 = byteBufferOrder.get();
                byte[] bArr = new byte[byteBufferOrder.getShort()];
                byteBufferOrder.get(bArr);
                Charset UTF_8 = StandardCharsets.UTF_8;
                p.h(UTF_8, "UTF_8");
                String str = new String(bArr, UTF_8);
                if (b10 == 0) {
                    floatArrayValue = new ParamValue.IntValue(byteBufferOrder.getInt());
                } else if (b10 == 1) {
                    floatArrayValue = new ParamValue.LongValue(byteBufferOrder.getLong());
                } else if (b10 == 2) {
                    floatArrayValue = new ParamValue.FloatValue(byteBufferOrder.getFloat());
                } else if (b10 == 3) {
                    floatArrayValue = new ParamValue.DoubleValue(byteBufferOrder.getDouble());
                } else if (b10 == 4) {
                    floatArrayValue = new ParamValue.BooleanValue(byteBufferOrder.get() != 0);
                } else if (b10 == 5) {
                    byte[] bArr2 = new byte[byteBufferOrder.getInt()];
                    byteBufferOrder.get(bArr2);
                    p.h(UTF_8, "UTF_8");
                    floatArrayValue = new ParamValue.StringValue(new String(bArr2, UTF_8));
                } else if (b10 == 6) {
                    int i12 = byteBufferOrder.getInt();
                    int[] iArr = new int[i12];
                    for (int i13 = 0; i13 < i12; i13++) {
                        iArr[i13] = byteBufferOrder.getInt();
                    }
                    floatArrayValue = new ParamValue.IntArrayValue(iArr);
                } else {
                    if (b10 != 7) {
                        throw new IllegalArgumentException("Unknown param type: " + ((int) b10));
                    }
                    int i14 = byteBufferOrder.getInt();
                    float[] fArr = new float[i14];
                    for (int i15 = 0; i15 < i14; i15++) {
                        fArr[i15] = byteBufferOrder.getFloat();
                    }
                    floatArrayValue = new ParamValue.FloatArrayValue(fArr);
                }
                linkedHashMap.put(str, floatArrayValue);
            }
            return new ContentParams(linkedHashMap, null);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue;", "", "<init>", "()V", "IntValue", "LongValue", "FloatValue", "DoubleValue", "BooleanValue", "StringValue", "IntArrayValue", "FloatArrayValue", "Lcom/stepos/core/data/ContentParams$ParamValue$BooleanValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$DoubleValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$FloatArrayValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$FloatValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$IntArrayValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$IntValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$LongValue;", "Lcom/stepos/core/data/ContentParams$ParamValue$StringValue;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class ParamValue {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$BooleanValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "(Z)V", "getValue", "()Z", "component1", ChatTracker.CLICK_COPY, "equals", "other", "", "hashCode", "", "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class BooleanValue extends ParamValue {
            private final boolean value;

            public BooleanValue(boolean z10) {
                super(null);
                this.value = z10;
            }

            public static /* synthetic */ BooleanValue copy$default(BooleanValue booleanValue, boolean z10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    z10 = booleanValue.value;
                }
                return booleanValue.copy(z10);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getValue() {
                return this.value;
            }

            public final BooleanValue copy(boolean value) {
                return new BooleanValue(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BooleanValue) && this.value == ((BooleanValue) other).value;
            }

            public final boolean getValue() {
                return this.value;
            }

            public int hashCode() {
                return Boolean.hashCode(this.value);
            }

            public String toString() {
                return "BooleanValue(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$DoubleValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "(D)V", "getValue", "()D", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class DoubleValue extends ParamValue {
            private final double value;

            public DoubleValue(double d10) {
                super(null);
                this.value = d10;
            }

            public static /* synthetic */ DoubleValue copy$default(DoubleValue doubleValue, double d10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    d10 = doubleValue.value;
                }
                return doubleValue.copy(d10);
            }

            /* renamed from: component1, reason: from getter */
            public final double getValue() {
                return this.value;
            }

            public final DoubleValue copy(double value) {
                return new DoubleValue(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DoubleValue) && Double.compare(this.value, ((DoubleValue) other).value) == 0;
            }

            public final double getValue() {
                return this.value;
            }

            public int hashCode() {
                return Double.hashCode(this.value);
            }

            public String toString() {
                return "DoubleValue(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$FloatArrayValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "([F)V", "getValue", "()[F", "equals", "", "other", "", "hashCode", "", "component1", ChatTracker.CLICK_COPY, "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class FloatArrayValue extends ParamValue {
            private final float[] value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FloatArrayValue(float[] value) {
                super(null);
                p.i(value, "value");
                this.value = value;
            }

            public static /* synthetic */ FloatArrayValue copy$default(FloatArrayValue floatArrayValue, float[] fArr, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    fArr = floatArrayValue.value;
                }
                return floatArrayValue.copy(fArr);
            }

            /* renamed from: component1, reason: from getter */
            public final float[] getValue() {
                return this.value;
            }

            public final FloatArrayValue copy(float[] value) {
                p.i(value, "value");
                return new FloatArrayValue(value);
            }

            public boolean equals(Object other) {
                return (other instanceof FloatArrayValue) && Arrays.equals(this.value, ((FloatArrayValue) other).value);
            }

            public final float[] getValue() {
                return this.value;
            }

            public int hashCode() {
                return Arrays.hashCode(this.value);
            }

            public String toString() {
                return "FloatArrayValue(value=" + Arrays.toString(this.value) + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$FloatValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "(F)V", "getValue", "()F", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class FloatValue extends ParamValue {
            private final float value;

            public FloatValue(float f10) {
                super(null);
                this.value = f10;
            }

            public static /* synthetic */ FloatValue copy$default(FloatValue floatValue, float f10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    f10 = floatValue.value;
                }
                return floatValue.copy(f10);
            }

            /* renamed from: component1, reason: from getter */
            public final float getValue() {
                return this.value;
            }

            public final FloatValue copy(float value) {
                return new FloatValue(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FloatValue) && Float.compare(this.value, ((FloatValue) other).value) == 0;
            }

            public final float getValue() {
                return this.value;
            }

            public int hashCode() {
                return Float.hashCode(this.value);
            }

            public String toString() {
                return "FloatValue(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$IntArrayValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "([I)V", "getValue", "()[I", "equals", "", "other", "", "hashCode", "", "component1", ChatTracker.CLICK_COPY, "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class IntArrayValue extends ParamValue {
            private final int[] value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public IntArrayValue(int[] value) {
                super(null);
                p.i(value, "value");
                this.value = value;
            }

            public static /* synthetic */ IntArrayValue copy$default(IntArrayValue intArrayValue, int[] iArr, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    iArr = intArrayValue.value;
                }
                return intArrayValue.copy(iArr);
            }

            /* renamed from: component1, reason: from getter */
            public final int[] getValue() {
                return this.value;
            }

            public final IntArrayValue copy(int[] value) {
                p.i(value, "value");
                return new IntArrayValue(value);
            }

            public boolean equals(Object other) {
                return (other instanceof IntArrayValue) && Arrays.equals(this.value, ((IntArrayValue) other).value);
            }

            public final int[] getValue() {
                return this.value;
            }

            public int hashCode() {
                return Arrays.hashCode(this.value);
            }

            public String toString() {
                return "IntArrayValue(value=" + Arrays.toString(this.value) + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$IntValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "(I)V", "getValue", "()I", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class IntValue extends ParamValue {
            private final int value;

            public IntValue(int i10) {
                super(null);
                this.value = i10;
            }

            public static /* synthetic */ IntValue copy$default(IntValue intValue, int i10, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    i10 = intValue.value;
                }
                return intValue.copy(i10);
            }

            /* renamed from: component1, reason: from getter */
            public final int getValue() {
                return this.value;
            }

            public final IntValue copy(int value) {
                return new IntValue(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof IntValue) && this.value == ((IntValue) other).value;
            }

            public final int getValue() {
                return this.value;
            }

            public int hashCode() {
                return Integer.hashCode(this.value);
            }

            public String toString() {
                return "IntValue(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$LongValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "(J)V", "getValue", "()J", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class LongValue extends ParamValue {
            private final long value;

            public LongValue(long j10) {
                super(null);
                this.value = j10;
            }

            public static /* synthetic */ LongValue copy$default(LongValue longValue, long j10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    j10 = longValue.value;
                }
                return longValue.copy(j10);
            }

            /* renamed from: component1, reason: from getter */
            public final long getValue() {
                return this.value;
            }

            public final LongValue copy(long value) {
                return new LongValue(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LongValue) && this.value == ((LongValue) other).value;
            }

            public final long getValue() {
                return this.value;
            }

            public int hashCode() {
                return Long.hashCode(this.value);
            }

            public String toString() {
                return "LongValue(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/core/data/ContentParams$ParamValue$StringValue;", "Lcom/stepos/core/data/ContentParams$ParamValue;", UxipConstants.f30680s, "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class StringValue extends ParamValue {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StringValue(String value) {
                super(null);
                p.i(value, "value");
                this.value = value;
            }

            public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = stringValue.value;
                }
                return stringValue.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final StringValue copy(String value) {
                p.i(value, "value");
                return new StringValue(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StringValue) && p.d(this.value, ((StringValue) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "StringValue(value=" + this.value + ")";
            }
        }

        public /* synthetic */ ParamValue(i iVar) {
            this();
        }

        private ParamValue() {
        }
    }

    public /* synthetic */ ContentParams(Map map, i iVar) {
        this((Map<String, ? extends ParamValue>) map);
    }

    public static final ContentParams empty() {
        return INSTANCE.empty();
    }

    public static final ContentParams fromByteArray(byte[] bArr) {
        return INSTANCE.fromByteArray(bArr);
    }

    public static /* synthetic */ boolean getBoolean$default(ContentParams contentParams, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return contentParams.getBoolean(str, z10);
    }

    public static /* synthetic */ double getDouble$default(ContentParams contentParams, String str, double d10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            d10 = 0.0d;
        }
        return contentParams.getDouble(str, d10);
    }

    public static /* synthetic */ float getFloat$default(ContentParams contentParams, String str, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        return contentParams.getFloat(str, f10);
    }

    public static /* synthetic */ int getInt$default(ContentParams contentParams, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return contentParams.getInt(str, i10);
    }

    public static /* synthetic */ long getLong$default(ContentParams contentParams, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return contentParams.getLong(str, j10);
    }

    public static /* synthetic */ String getString$default(ContentParams contentParams, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return contentParams.getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$2(Map.Entry it) {
        p.i(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int calculateByteSize() {
        /*
            r8 = this;
            java.util.Map<java.lang.String, com.stepos.core.data.ContentParams$ParamValue> r8 = r8.params
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
            r0 = 4
            r1 = r0
        Lc:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r8.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            com.stepos.core.data.ContentParams$ParamValue r2 = (com.stepos.core.data.ContentParams.ParamValue) r2
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r5 = "UTF_8"
            kotlin.jvm.internal.p.h(r4, r5)
            byte[] r3 = r3.getBytes(r4)
            java.lang.String r6 = "getBytes(...)"
            kotlin.jvm.internal.p.h(r3, r6)
            int r3 = r3.length
            int r3 = r3 + 3
            int r1 = r1 + r3
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.IntValue
            if (r3 == 0) goto L3e
        L3c:
            r7 = r0
            goto L86
        L3e:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.LongValue
            r7 = 8
            if (r3 == 0) goto L45
            goto L86
        L45:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.FloatValue
            if (r3 == 0) goto L4a
            goto L3c
        L4a:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.DoubleValue
            if (r3 == 0) goto L4f
            goto L86
        L4f:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.BooleanValue
            if (r3 == 0) goto L55
            r7 = 1
            goto L86
        L55:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.StringValue
            if (r3 == 0) goto L6d
            com.stepos.core.data.ContentParams$ParamValue$StringValue r2 = (com.stepos.core.data.ContentParams.ParamValue.StringValue) r2
            java.lang.String r2 = r2.getValue()
            kotlin.jvm.internal.p.h(r4, r5)
            byte[] r2 = r2.getBytes(r4)
            kotlin.jvm.internal.p.h(r2, r6)
            int r2 = r2.length
        L6a:
            int r7 = r2 + 4
            goto L86
        L6d:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.IntArrayValue
            if (r3 == 0) goto L7a
            com.stepos.core.data.ContentParams$ParamValue$IntArrayValue r2 = (com.stepos.core.data.ContentParams.ParamValue.IntArrayValue) r2
            int[] r2 = r2.getValue()
            int r2 = r2.length
        L78:
            int r2 = r2 * r0
            goto L6a
        L7a:
            boolean r3 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.FloatArrayValue
            if (r3 == 0) goto L88
            com.stepos.core.data.ContentParams$ParamValue$FloatArrayValue r2 = (com.stepos.core.data.ContentParams.ParamValue.FloatArrayValue) r2
            float[] r2 = r2.getValue()
            int r2 = r2.length
            goto L78
        L86:
            int r1 = r1 + r7
            goto Lc
        L88:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.data.ContentParams.calculateByteSize():int");
    }

    public final boolean containsKey(String key) {
        p.i(key, "key");
        return this.params.containsKey(key);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getBoolean(String key, boolean z10) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.BooleanValue booleanValue = paramValue instanceof ParamValue.BooleanValue ? (ParamValue.BooleanValue) paramValue : null;
        return booleanValue != null ? booleanValue.getValue() : z10;
    }

    public final double getDouble(String key, double d10) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.DoubleValue doubleValue = paramValue instanceof ParamValue.DoubleValue ? (ParamValue.DoubleValue) paramValue : null;
        return doubleValue != null ? doubleValue.getValue() : d10;
    }

    public final float getFloat(String key, float f10) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.FloatValue floatValue = paramValue instanceof ParamValue.FloatValue ? (ParamValue.FloatValue) paramValue : null;
        return floatValue != null ? floatValue.getValue() : f10;
    }

    public final float[] getFloatArray(String key) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.FloatArrayValue floatArrayValue = paramValue instanceof ParamValue.FloatArrayValue ? (ParamValue.FloatArrayValue) paramValue : null;
        if (floatArrayValue != null) {
            return floatArrayValue.getValue();
        }
        return null;
    }

    public final int getInt(String key, int i10) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.IntValue intValue = paramValue instanceof ParamValue.IntValue ? (ParamValue.IntValue) paramValue : null;
        return intValue != null ? intValue.getValue() : i10;
    }

    public final int[] getIntArray(String key) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.IntArrayValue intArrayValue = paramValue instanceof ParamValue.IntArrayValue ? (ParamValue.IntArrayValue) paramValue : null;
        if (intArrayValue != null) {
            return intArrayValue.getValue();
        }
        return null;
    }

    public final long getLong(String key, long j10) {
        p.i(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.LongValue longValue = paramValue instanceof ParamValue.LongValue ? (ParamValue.LongValue) paramValue : null;
        return longValue != null ? longValue.getValue() : j10;
    }

    public final String getString(String key, String str) {
        String value;
        p.i(key, "key");
        p.i(str, "default");
        ParamValue paramValue = this.params.get(key);
        ParamValue.StringValue stringValue = paramValue instanceof ParamValue.StringValue ? (ParamValue.StringValue) paramValue : null;
        return (stringValue == null || (value = stringValue.getValue()) == null) ? str : value;
    }

    public final boolean isEmpty() {
        return this.params.isEmpty();
    }

    public final Set<String> keys() {
        return this.params.keySet();
    }

    public final int size() {
        return this.params.size();
    }

    public final byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(calculateByteSize()).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(this.params.size());
        for (Map.Entry<String, ParamValue> entry : this.params.entrySet()) {
            String key = entry.getKey();
            ParamValue value = entry.getValue();
            Charset UTF_8 = StandardCharsets.UTF_8;
            p.h(UTF_8, "UTF_8");
            byte[] bytes = key.getBytes(UTF_8);
            p.h(bytes, "getBytes(...)");
            int i10 = 0;
            if (value instanceof ParamValue.IntValue) {
                byteBufferOrder.put(TYPE_INT);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putInt(((ParamValue.IntValue) value).getValue());
            } else if (value instanceof ParamValue.LongValue) {
                byteBufferOrder.put((byte) 1);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putLong(((ParamValue.LongValue) value).getValue());
            } else if (value instanceof ParamValue.FloatValue) {
                byteBufferOrder.put((byte) 2);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putFloat(((ParamValue.FloatValue) value).getValue());
            } else if (value instanceof ParamValue.DoubleValue) {
                byteBufferOrder.put((byte) 3);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putDouble(((ParamValue.DoubleValue) value).getValue());
            } else if (value instanceof ParamValue.BooleanValue) {
                byteBufferOrder.put((byte) 4);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.put(((ParamValue.BooleanValue) value).getValue() ? (byte) 1 : (byte) 0);
            } else if (value instanceof ParamValue.StringValue) {
                String value2 = ((ParamValue.StringValue) value).getValue();
                p.h(UTF_8, "UTF_8");
                byte[] bytes2 = value2.getBytes(UTF_8);
                p.h(bytes2, "getBytes(...)");
                byteBufferOrder.put((byte) 5);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putInt(bytes2.length);
                byteBufferOrder.put(bytes2);
            } else if (value instanceof ParamValue.IntArrayValue) {
                byteBufferOrder.put((byte) 6);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                ParamValue.IntArrayValue intArrayValue = (ParamValue.IntArrayValue) value;
                byteBufferOrder.putInt(intArrayValue.getValue().length);
                int[] value3 = intArrayValue.getValue();
                int length = value3.length;
                while (i10 < length) {
                    byteBufferOrder.putInt(value3[i10]);
                    i10++;
                }
                t tVar = t.f7040a;
            } else {
                if (!(value instanceof ParamValue.FloatArrayValue)) {
                    throw new NoWhenBranchMatchedException();
                }
                byteBufferOrder.put(TYPE_FLOAT_ARRAY);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                ParamValue.FloatArrayValue floatArrayValue = (ParamValue.FloatArrayValue) value;
                byteBufferOrder.putInt(floatArrayValue.getValue().length);
                float[] value4 = floatArrayValue.getValue();
                int length2 = value4.length;
                while (i10 < length2) {
                    byteBufferOrder.putFloat(value4[i10]);
                    i10++;
                }
                t tVar2 = t.f7040a;
            }
        }
        byte[] bArrArray = byteBufferOrder.array();
        p.h(bArrArray, "array(...)");
        byte[] bArrCopyOf = Arrays.copyOf(bArrArray, byteBufferOrder.position());
        p.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public String toString() {
        return "ContentParams(" + F.A0(this.params.entrySet(), null, null, null, 0, null, new InterfaceC5074l() { // from class: Q6.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ContentParams.toString$lambda$2((Map.Entry) obj);
            }
        }, 31, null) + ")";
    }

    public final ContentParams withInt(String key, int value) {
        p.i(key, "key");
        return new ContentParams((Map<String, ? extends ParamValue>) a.s(this.params, j.a(key, new ParamValue.IntValue(value))));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        byte[] byteArray = toByteArray();
        parcel.writeInt(byteArray.length);
        parcel.writeByteArray(byteArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ContentParams(Map<String, ? extends ParamValue> map) {
        this.params = map;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentParams(Parcel parcel) {
        this((Map<String, ? extends ParamValue>) INSTANCE.readParamsFromParcel(parcel));
        p.i(parcel, "parcel");
    }
}
