package com.stepos.ailauncher.foundation.credential;

import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.ApiEnvelope;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import retrofit2.HttpException;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$call$2", f = "CredentialBrokerClient.kt", l = {223}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CredentialBrokerClient$call$2<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super CredentialBrokerClient.a<? extends T>>, Object> {
    final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super ApiEnvelope<T>>, Object> $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CredentialBrokerClient$call$2(InterfaceC5074l<? super InterfaceC4014c<? super ApiEnvelope<T>>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super CredentialBrokerClient$call$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$block = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CredentialBrokerClient$call$2(this.$block, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super CredentialBrokerClient.a<? extends T>> interfaceC4014c) {
        return ((CredentialBrokerClient$call$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String strM;
        Object objG = C4063a.g();
        int i10 = this.label;
        String str = CredentialBrokerClient.ERR_NETWORK;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC5074l<InterfaceC4014c<? super ApiEnvelope<T>>, Object> interfaceC5074l = this.$block;
                this.label = 1;
                obj = interfaceC5074l.invoke(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            ApiEnvelope apiEnvelope = (ApiEnvelope) obj;
            if (apiEnvelope.isSuccess()) {
                Object data = apiEnvelope.getData();
                if (data == null) {
                    data = t.f7040a;
                }
                return new CredentialBrokerClient.a.Ok(data);
            }
            C4148a.u("CredentialBroker", "业务失败 status=" + apiEnvelope.getStatus() + " msg=" + apiEnvelope.getMsg(), false, 4, null);
            int status = apiEnvelope.getStatus();
            String msg = apiEnvelope.getMsg();
            if (msg == null) {
                msg = CredentialBrokerClient.ERR_NETWORK;
            }
            return new CredentialBrokerClient.a.Fail(status, msg);
        } catch (IOException e10) {
            C4148a.t("CredentialBroker", "网络失败", e10, false, 8, null);
            return new CredentialBrokerClient.a.Fail(0, CredentialBrokerClient.ERR_NETWORK);
        } catch (CancellationException e11) {
            throw e11;
        } catch (IllegalStateException e12) {
            C4148a.t("CredentialBroker", "未配置", e12, false, 8, null);
            return new CredentialBrokerClient.a.Fail(0, CredentialBrokerClient.ERR_NETWORK);
        } catch (HttpException e13) {
            int iA = e13.a();
            if (iA == 401 || iA == 403) {
                str = CredentialBrokerClient.ERR_UNAUTHORIZED;
            } else if (iA == 404) {
                str = CredentialBrokerClient.ERR_NOT_FOUND;
            } else if (iA < 500 && (strM = CredentialBrokerClient.INSTANCE.m(e13)) != null) {
                str = strM;
            }
            C4148a.u("CredentialBroker", "HTTP 失败 code=" + iA + " msg=" + str, false, 4, null);
            return new CredentialBrokerClient.a.Fail(iA, str);
        } catch (Exception e14) {
            C4148a.t("CredentialBroker", "异常", e14, false, 8, null);
            return new CredentialBrokerClient.a.Fail(0, CredentialBrokerClient.ERR_NETWORK);
        }
    }
}
