package com.stepos.ailauncher.chat;

import La.D;
import Ua.M;
import android.net.Uri;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$saveImg2File$2", f = "PickFileMediatorActivity.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PickFileMediatorViewModel$saveImg2File$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Pair<? extends String, ? extends String>>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ PickFileMediatorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickFileMediatorViewModel$saveImg2File$2(PickFileMediatorViewModel pickFileMediatorViewModel, Uri uri, InterfaceC4014c<? super PickFileMediatorViewModel$saveImg2File$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = pickFileMediatorViewModel;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PickFileMediatorViewModel$saveImg2File$2(this.this$0, this.$uri, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Pair<String, String>> interfaceC4014c) {
        return ((PickFileMediatorViewModel$saveImg2File$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String absolutePath;
        File file;
        InputStream inputStreamOpenInputStream;
        String str = "";
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            String type = this.this$0.application.getContentResolver().getType(this.$uri);
            String strT = type != null ? D.T(type, "image/", "", false, 4, null) : null;
            File file2 = new File(this.this$0.application.getCacheDir().getAbsolutePath() + File.separator + "galleryCache");
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(file2, System.currentTimeMillis() + "." + strT);
            inputStreamOpenInputStream = this.this$0.application.getContentResolver().openInputStream(this.$uri);
        } catch (Exception e10) {
            e = e10;
            absolutePath = "";
        }
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
                        absolutePath = file.getAbsolutePath();
                        kotlin.jvm.internal.p.h(absolutePath, "getAbsolutePath(...)");
                        try {
                            String name = file.getName();
                            kotlin.jvm.internal.p.h(name, "getName(...)");
                            str = name;
                        } catch (Exception e11) {
                            e = e11;
                            C4148a.h("PickFileMediatorViewModel", "Unable to open content: " + this.$uri + ", " + e.getMessage(), false, 4, null);
                            C4148a.d("PickFileMediatorViewModel", "File path is " + absolutePath, false, 4, null);
                            return Y8.j.a(absolutePath, str);
                        }
                        C4148a.d("PickFileMediatorViewModel", "File path is " + absolutePath, false, 4, null);
                        return Y8.j.a(absolutePath, str);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends String, ? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Pair<String, String>>) interfaceC4014c);
    }
}
