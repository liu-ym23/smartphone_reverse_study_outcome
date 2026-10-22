package com.stepos.ailauncher.chat.activity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.chat.api.SystemVoicesResponse;
import com.stepos.ailauncher.chat.api.VoiceDetail;
import com.stepos.ailauncher.network.repository.DictionaryRepositoryManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/chat/api/SystemVoicesResponse;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/chat/api/SystemVoicesResponse;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.SoundSettingActivity$loadVoices$1$result$1$1", f = "SoundSettingActivity.kt", l = {105}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SoundSettingActivity$loadVoices$1$result$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super SystemVoicesResponse>, Object> {
    int label;

    public SoundSettingActivity$loadVoices$1$result$1$1(InterfaceC4014c<? super SoundSettingActivity$loadVoices$1$result$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SoundSettingActivity$loadVoices$1$result$1$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super SystemVoicesResponse> interfaceC4014c) {
        return ((SoundSettingActivity$loadVoices$1$result$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            DictionaryRepositoryManager dictionaryRepositoryManager = DictionaryRepositoryManager.INSTANCE;
            this.label = 1;
            obj = dictionaryRepositoryManager.loadSettingsVoiceList(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        String str = (String) obj;
        if (str == null) {
            throw new IllegalStateException("voice-details dictionary is empty");
        }
        Object objFromJson = new Gson().fromJson(str, new TypeToken<LinkedHashMap<String, VoiceDetail>>() { // from class: com.stepos.ailauncher.chat.activity.SoundSettingActivity$loadVoices$1$result$1$1$mapType$1
        }.getType());
        kotlin.jvm.internal.p.h(objFromJson, "fromJson(...)");
        LinkedHashMap linkedHashMap = (LinkedHashMap) objFromJson;
        Set setKeySet = linkedHashMap.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        return new SystemVoicesResponse(true, null, Z8.F.m1(setKeySet), linkedHashMap, 2, null);
    }
}
