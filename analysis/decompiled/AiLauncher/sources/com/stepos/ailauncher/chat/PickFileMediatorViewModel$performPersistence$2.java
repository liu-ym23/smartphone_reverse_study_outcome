package com.stepos.ailauncher.chat;

import Ua.M;
import android.net.Uri;
import android.text.TextUtils;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l9.C4877a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0005\u001a\"\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$performPersistence$2", f = "PickFileMediatorActivity.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PickFileMediatorViewModel$performPersistence$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Pair<? extends String, ? extends Pair<? extends String, ? extends Integer>>>, Object> {
    final /* synthetic */ Pair<String, Integer> $fileInfo;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ PickFileMediatorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickFileMediatorViewModel$performPersistence$2(Pair<String, Integer> pair, PickFileMediatorViewModel pickFileMediatorViewModel, Uri uri, InterfaceC4014c<? super PickFileMediatorViewModel$performPersistence$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileInfo = pair;
        this.this$0 = pickFileMediatorViewModel;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PickFileMediatorViewModel$performPersistence$2(this.$fileInfo, this.this$0, this.$uri, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Pair<String, Pair<String, Integer>>> interfaceC4014c) {
        return ((PickFileMediatorViewModel$performPersistence$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (this.$fileInfo.f().intValue() == 0 && TextUtils.isEmpty(this.$fileInfo.e())) {
            throw new Throwable("File size is 0");
        }
        try {
            File file = new File(this.this$0.application.getCacheDir().getAbsolutePath(), System.currentTimeMillis() + "_" + ((Object) this.$fileInfo.e()));
            InputStream inputStreamOpenInputStream = this.this$0.application.getContentResolver().openInputStream(this.$uri);
            if (inputStreamOpenInputStream == null) {
                throw new IOException("openInputStream returned null for " + this.$uri);
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            C4877a.a(bufferedInputStream, bufferedOutputStream, com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                            l9.b.a(bufferedOutputStream, null);
                            l9.b.a(fileOutputStream, null);
                            l9.b.a(bufferedInputStream, null);
                            l9.b.a(inputStreamOpenInputStream, null);
                            C4148a.d("PickFileMediatorViewModel", "File " + file.getAbsolutePath() + " is stored.", false, 4, null);
                            return Y8.j.a(file.getAbsolutePath(), this.$fileInfo);
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e10) {
            C4148a.h("PickFileMediatorViewModel", String.valueOf(e10.getMessage()), false, 4, null);
            throw new Throwable("Saving file is not completed.");
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends String, ? extends Pair<? extends String, ? extends Integer>>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Pair<String, Pair<String, Integer>>>) interfaceC4014c);
    }
}
