package com.stepos.aiengine.adapter;

import M5.b;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.asr.AsrAudioFile;
import com.stepos.aiengine.algorithm.asr.AsrFileRecognitionListener;
import com.stepos.aiengine.algorithm.asr.IAsrFileRecognition;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.AbilityHandle;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrFileAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/asr/IAsrFileRecognition;", "Lcom/stepos/core/AbilityHandle;", "handle", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "waitMsOverride", "<init>", "(Lcom/stepos/core/AbilityHandle;Lp9/l;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "files", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "listener", "args", "", "recognize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;Landroid/os/Bundle;)I", e.f30860s, "", "cancel", "(J)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate;", "c", "Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate;", "delegate", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrFileAbilityAdapter implements IAsrFileRecognition {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Bundle, Long> waitMsOverride;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AsrFileRecognitionDelegate delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public AsrFileAbilityAdapter(AbilityHandle handle, InterfaceC5074l<? super Bundle, Long> interfaceC5074l) {
        p.i(handle, "handle");
        this.handle = handle;
        this.waitMsOverride = interfaceC5074l;
        this.delegate = new AsrFileRecognitionDelegate(handle, interfaceC5074l);
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrFileRecognition
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrFileRecognition
    public int recognize(AlgorithmToken token, List<AsrAudioFile> files, AsrFileRecognitionListener listener, Bundle args) {
        p.i(token, "token");
        p.i(files, "files");
        p.i(listener, "listener");
        return this.delegate.recognize(token, files, listener, args);
    }

    public /* synthetic */ AsrFileAbilityAdapter(AbilityHandle abilityHandle, InterfaceC5074l interfaceC5074l, int i10, i iVar) {
        this(abilityHandle, (i10 & 2) != 0 ? null : interfaceC5074l);
    }
}
