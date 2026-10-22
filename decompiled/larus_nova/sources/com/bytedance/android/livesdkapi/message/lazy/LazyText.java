package com.bytedance.android.livesdkapi.message.lazy;

import am3.g;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(LazyTextJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001e\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001e\u0010!B\t\b\u0016¢\u0006\u0004\b\u001e\u0010\"J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/lazy/LazyText;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/message/lazy/ITextWrapper;", "Lvh7/h;", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "Lcom/google/gson/JsonObject;", "serializedJson", "Lcom/google/gson/JsonObject;", "getSerializedJson$live_model_api_saasRelease", "()Lcom/google/gson/JsonObject;", "setSerializedJson$live_model_api_saasRelease", "(Lcom/google/gson/JsonObject;)V", "jsonDecoded", "Lcom/bytedance/android/live/base/model/message/a5;", "getJsonDecoded$live_model_api_saasRelease", "()Lcom/bytedance/android/live/base/model/message/a5;", "setJsonDecoded$live_model_api_saasRelease", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "_text$delegate", "Lkotlin/Lazy;", "get_text", "_text", "", "rawPB", "[B", "getRawPB", "()[B", "setRawPB", "([B)V", "<init>", "Lam3/g;", "reader", "(Lam3/g;)V", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LazyText extends FlexModelBase<ITextWrapper> implements ITextWrapper, h {
    public static final Companion Companion = null;
    private static boolean lazySupport;
    private final Lazy _text$delegate;
    private a5 jsonDecoded;
    private byte[] rawPB;
    private JsonObject serializedJson;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/lazy/LazyText$Companion;", "", "()V", "lazySupport", "", "getLazySupport", "()Z", "setLazySupport", "(Z)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final boolean getLazySupport() {
            return LazyText.access$getLazySupport$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setLazySupport(boolean r100) {
            LazyText.access$setLazySupport$cp(r100);
        }
    }

    public LazyText() {
        this(null);
    }

    private final a5 get_text() {
        return (a5) this._text$delegate.getValue();
    }

    static {
        Companion = new Companion(null);
        lazySupport = true;
    }

    @Override // com.bytedance.android.livesdkapi.message.lazy.ITextWrapper
    public a5 getText() {
        a5 r100 = get_text();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.jsonDecoded;
    }

    public static final /* synthetic */ boolean access$getLazySupport$cp() {
        return lazySupport;
    }

    public final a5 getJsonDecoded$live_model_api_saasRelease() {
        return this.jsonDecoded;
    }

    @Override // com.bytedance.android.livesdkapi.message.lazy.ITextWrapper
    public byte[] getRawPB() {
        return this.rawPB;
    }

    public final JsonObject getSerializedJson$live_model_api_saasRelease() {
        return this.serializedJson;
    }

    public LazyText(g r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        this(am3.h.b(r100));
        if (lazySupport == true) goto L6;
        get_text();
        return;
    }

    public static final /* synthetic */ void access$setLazySupport$cp(boolean r100) {
        lazySupport = r100;
    }

    public final void setJsonDecoded$live_model_api_saasRelease(a5 r100) {
        this.jsonDecoded = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.lazy.ITextWrapper
    public void setRawPB(byte[] r100) {
        this.rawPB = r100;
    }

    public final void setSerializedJson$live_model_api_saasRelease(JsonObject r100) {
        this.serializedJson = r100;
    }

    public LazyText(byte[] r100) {
        super(ITextWrapper.class);
        this.rawPB = r100;
        this._text$delegate = LazyKt.lazy(new LazyText$_text$2(this));
    }
}
