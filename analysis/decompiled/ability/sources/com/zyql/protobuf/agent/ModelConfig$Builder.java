package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import o7.v;

/* loaded from: classes2.dex */
public final class ModelConfig$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ModelConfig$Builder(int i) {
        this();
    }

    public ModelConfig$Builder addAllStop(Iterable<String> iterable) {
        copyOnWrite();
        v.D((v) this.instance, iterable);
        return this;
    }

    public ModelConfig$Builder addStop(String str) {
        copyOnWrite();
        v.E((v) this.instance, str);
        return this;
    }

    public ModelConfig$Builder addStopBytes(ByteString byteString) {
        copyOnWrite();
        v.F((v) this.instance, byteString);
        return this;
    }

    public ModelConfig$Builder clearExtra() {
        copyOnWrite();
        v.M((v) this.instance).clear();
        return this;
    }

    public ModelConfig$Builder clearMaxTokens() {
        copyOnWrite();
        v.G((v) this.instance);
        return this;
    }

    public ModelConfig$Builder clearModel() {
        copyOnWrite();
        v.H((v) this.instance);
        return this;
    }

    public ModelConfig$Builder clearProvider() {
        copyOnWrite();
        v.I((v) this.instance);
        return this;
    }

    public ModelConfig$Builder clearStop() {
        copyOnWrite();
        v.J((v) this.instance);
        return this;
    }

    public ModelConfig$Builder clearTemperature() {
        copyOnWrite();
        v.K((v) this.instance);
        return this;
    }

    public ModelConfig$Builder clearTopP() {
        copyOnWrite();
        v.L((v) this.instance);
        return this;
    }

    public boolean containsExtra(String str) {
        str.getClass();
        return ((v) this.instance).Y().containsKey(str);
    }

    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    public int getExtraCount() {
        return ((v) this.instance).Y().size();
    }

    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(((v) this.instance).Y());
    }

    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        Map mapY = ((v) this.instance).Y();
        return mapY.containsKey(str) ? (String) mapY.get(str) : str2;
    }

    public String getExtraOrThrow(String str) {
        str.getClass();
        Map mapY = ((v) this.instance).Y();
        if (mapY.containsKey(str)) {
            return (String) mapY.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int getMaxTokens() {
        return ((v) this.instance).Z();
    }

    public String getModel() {
        return ((v) this.instance).a0();
    }

    public ByteString getModelBytes() {
        return ((v) this.instance).b0();
    }

    public String getProvider() {
        return ((v) this.instance).c0();
    }

    public ByteString getProviderBytes() {
        return ((v) this.instance).d0();
    }

    public String getStop(int i) {
        return ((v) this.instance).e0(i);
    }

    public ByteString getStopBytes(int i) {
        return ((v) this.instance).f0(i);
    }

    public int getStopCount() {
        return ((v) this.instance).g0();
    }

    public List<String> getStopList() {
        return Collections.unmodifiableList(((v) this.instance).h0());
    }

    public float getTemperature() {
        return ((v) this.instance).i0();
    }

    public float getTopP() {
        return ((v) this.instance).j0();
    }

    public boolean hasMaxTokens() {
        return ((v) this.instance).k0();
    }

    public boolean hasTemperature() {
        return ((v) this.instance).l0();
    }

    public boolean hasTopP() {
        return ((v) this.instance).m0();
    }

    public ModelConfig$Builder putAllExtra(Map<String, String> map) {
        copyOnWrite();
        v.M((v) this.instance).putAll(map);
        return this;
    }

    public ModelConfig$Builder putExtra(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        v.M((v) this.instance).put(str, str2);
        return this;
    }

    public ModelConfig$Builder removeExtra(String str) {
        str.getClass();
        copyOnWrite();
        v.M((v) this.instance).remove(str);
        return this;
    }

    public ModelConfig$Builder setMaxTokens(int i) {
        copyOnWrite();
        v.N((v) this.instance, i);
        return this;
    }

    public ModelConfig$Builder setModel(String str) {
        copyOnWrite();
        v.O((v) this.instance, str);
        return this;
    }

    public ModelConfig$Builder setModelBytes(ByteString byteString) {
        copyOnWrite();
        v.P((v) this.instance, byteString);
        return this;
    }

    public ModelConfig$Builder setProvider(String str) {
        copyOnWrite();
        v.Q((v) this.instance, str);
        return this;
    }

    public ModelConfig$Builder setProviderBytes(ByteString byteString) {
        copyOnWrite();
        v.R((v) this.instance, byteString);
        return this;
    }

    public ModelConfig$Builder setStop(int i, String str) {
        copyOnWrite();
        v.S((v) this.instance, i, str);
        return this;
    }

    public ModelConfig$Builder setTemperature(float f) {
        copyOnWrite();
        v.T((v) this.instance, f);
        return this;
    }

    public ModelConfig$Builder setTopP(float f) {
        copyOnWrite();
        v.U((v) this.instance, f);
        return this;
    }

    private ModelConfig$Builder() {
        super(v.DEFAULT_INSTANCE);
    }
}
