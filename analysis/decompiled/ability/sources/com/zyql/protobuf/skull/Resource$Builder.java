package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import v7.l;

/* loaded from: classes2.dex */
public final class Resource$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Resource$Builder(int i) {
        this();
    }

    public Resource$Builder clearContent() {
        copyOnWrite();
        l.D((l) this.instance);
        return this;
    }

    public Resource$Builder clearDescription() {
        copyOnWrite();
        l.E((l) this.instance);
        return this;
    }

    public Resource$Builder clearExtra() {
        copyOnWrite();
        l.J((l) this.instance).clear();
        return this;
    }

    public Resource$Builder clearMimeType() {
        copyOnWrite();
        l.F((l) this.instance);
        return this;
    }

    public Resource$Builder clearTitle() {
        copyOnWrite();
        l.G((l) this.instance);
        return this;
    }

    public Resource$Builder clearType() {
        copyOnWrite();
        l.H((l) this.instance);
        return this;
    }

    public Resource$Builder clearUri() {
        copyOnWrite();
        l.I((l) this.instance);
        return this;
    }

    public boolean containsExtra(String str) {
        str.getClass();
        return ((l) this.instance).b0().containsKey(str);
    }

    public String getContent() {
        return ((l) this.instance).X();
    }

    public ByteString getContentBytes() {
        return ((l) this.instance).Y();
    }

    public String getDescription() {
        return ((l) this.instance).Z();
    }

    public ByteString getDescriptionBytes() {
        return ((l) this.instance).a0();
    }

    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    public int getExtraCount() {
        return ((l) this.instance).b0().size();
    }

    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(((l) this.instance).b0());
    }

    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        Map mapB0 = ((l) this.instance).b0();
        return mapB0.containsKey(str) ? (String) mapB0.get(str) : str2;
    }

    public String getExtraOrThrow(String str) {
        str.getClass();
        Map mapB0 = ((l) this.instance).b0();
        if (mapB0.containsKey(str)) {
            return (String) mapB0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getMimeType() {
        return ((l) this.instance).c0();
    }

    public ByteString getMimeTypeBytes() {
        return ((l) this.instance).d0();
    }

    public String getTitle() {
        return ((l) this.instance).e0();
    }

    public ByteString getTitleBytes() {
        return ((l) this.instance).f0();
    }

    public String getType() {
        return ((l) this.instance).g0();
    }

    public ByteString getTypeBytes() {
        return ((l) this.instance).h0();
    }

    public String getUri() {
        return ((l) this.instance).i0();
    }

    public ByteString getUriBytes() {
        return ((l) this.instance).j0();
    }

    public Resource$Builder putAllExtra(Map<String, String> map) {
        copyOnWrite();
        l.J((l) this.instance).putAll(map);
        return this;
    }

    public Resource$Builder putExtra(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        l.J((l) this.instance).put(str, str2);
        return this;
    }

    public Resource$Builder removeExtra(String str) {
        str.getClass();
        copyOnWrite();
        l.J((l) this.instance).remove(str);
        return this;
    }

    public Resource$Builder setContent(String str) {
        copyOnWrite();
        l.K((l) this.instance, str);
        return this;
    }

    public Resource$Builder setContentBytes(ByteString byteString) {
        copyOnWrite();
        l.L((l) this.instance, byteString);
        return this;
    }

    public Resource$Builder setDescription(String str) {
        copyOnWrite();
        l.M((l) this.instance, str);
        return this;
    }

    public Resource$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        l.N((l) this.instance, byteString);
        return this;
    }

    public Resource$Builder setMimeType(String str) {
        copyOnWrite();
        l.O((l) this.instance, str);
        return this;
    }

    public Resource$Builder setMimeTypeBytes(ByteString byteString) {
        copyOnWrite();
        l.P((l) this.instance, byteString);
        return this;
    }

    public Resource$Builder setTitle(String str) {
        copyOnWrite();
        l.Q((l) this.instance, str);
        return this;
    }

    public Resource$Builder setTitleBytes(ByteString byteString) {
        copyOnWrite();
        l.R((l) this.instance, byteString);
        return this;
    }

    public Resource$Builder setType(String str) {
        copyOnWrite();
        l.S((l) this.instance, str);
        return this;
    }

    public Resource$Builder setTypeBytes(ByteString byteString) {
        copyOnWrite();
        l.T((l) this.instance, byteString);
        return this;
    }

    public Resource$Builder setUri(String str) {
        copyOnWrite();
        l.U((l) this.instance, str);
        return this;
    }

    public Resource$Builder setUriBytes(ByteString byteString) {
        copyOnWrite();
        l.V((l) this.instance, byteString);
        return this;
    }

    private Resource$Builder() {
        super(l.DEFAULT_INSTANCE);
    }
}
