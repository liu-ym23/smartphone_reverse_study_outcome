package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010?\u001a\u00020\u0002¢\u0006\u0004\b@\u0010AJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\u00020\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0014\u0010%\u001a\u00020\"8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001e\u0010+\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010.\u001a\u00020\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001e\u00102\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u00101R$\u00109\u001a\n\u0018\u000103j\u0004\u0018\u0001`48\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\"8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b:\u0010$R\u001e\u0010>\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u00101¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IMainLuckyBoxRushResultExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/chatroom/model/o1;", "Lcom/bytedance/android/livesdk/chatroom/model/p1;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/chatroom/model/p1$c;", "getExpandAward", "()Lcom/bytedance/android/livesdk/chatroom/model/p1$c;", "expandAward", "", "getDressId", "()Ljava/lang/String;", "dressId", "", "getBoxType", "()I", "setBoxType", "(I)V", "boxType", "", "getCashCount", "()J", "setCashCount", "(J)V", "cashCount", "getDiamondCount", "setDiamondCount", "diamondCount", "", "getExpired", "()Z", AiBotPollingAuthResult.STATUS_EXPIRED, "Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "getGiftGuide", "()Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "setGiftGuide", "(Lcom/bytedance/android/livesdk/chatroom/model/o1$b;)V", "giftGuide", "getGiftId", "setGiftId", "giftId", "getGiftName", "setGiftName", "(Ljava/lang/String;)V", "giftName", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "getSucceed", "succeed", "getText", "setText", "text", "base", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/model/o1;)V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainLuckyBoxRushResultExtensionImpl extends ModelExtensionBase<o1, p1> implements p1, o1 {
    private final /* synthetic */ o1 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<o1>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<o1>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public int getBoxType() {
        return this.$$delegate_0.getBoxType();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public long getCashCount() {
        return this.$$delegate_0.getCashCount();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public long getDiamondCount() {
        return this.$$delegate_0.getDiamondCount();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public boolean getExpired() {
        return this.$$delegate_0.getExpired();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public o1.b getGiftGuide() {
        return this.$$delegate_0.getGiftGuide();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public long getGiftId() {
        return this.$$delegate_0.getGiftId();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public String getGiftName() {
        return this.$$delegate_0.getGiftName();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public py.k getImage() {
        return this.$$delegate_0.getImage();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public boolean getSucceed() {
        return this.$$delegate_0.getSucceed();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public String getText() {
        return this.$$delegate_0.getText();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setBoxType(int r100) {
        this.$$delegate_0.setBoxType(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setCashCount(long r100) {
        this.$$delegate_0.setCashCount(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setDiamondCount(long r100) {
        this.$$delegate_0.setDiamondCount(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setGiftGuide(o1.b r100) {
        this.$$delegate_0.setGiftGuide(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setGiftId(long r100) {
        this.$$delegate_0.setGiftId(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setGiftName(String r100) {
        this.$$delegate_0.setGiftName(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setImage(py.k r100) {
        this.$$delegate_0.setImage(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1, com.bytedance.android.livesdk.chatroom.model.o1
    public void setText(String r100) {
        this.$$delegate_0.setText(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1
    public String getDressId() {
        return (String) get(16, p1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1
    public p1.c getExpandAward() {
        return (p1.c) get(20, p1.class);
    }

    public IMainLuckyBoxRushResultExtensionImpl(o1 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
