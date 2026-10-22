package com.stepos.agentframework.adapter.bff.handler;

import B7.a;
import V4.C0260g;
import V4.l;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.ChatContentExtKt;
import com.stepos.agentframework.adapter.bff.IDataCallback;
import com.stepos.agentframework.adapter.bff.LogUtilKt;
import com.stepos.agentframework.adapter.netcore.ExtKt;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.common.AgentTaskState;
import com.stepos.common.FunctionCall;
import com.zyql.protobuf.common.LogLevel;
import com.zyql.protobuf.common.LogSender;
import com.zyql.protobuf.runtime.AgentTaskStateNotification$State;
import com.zyql.protobuf.runtime.InputMessageStateNotification$State;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import q7.C1808f;
import q7.C1809g;
import q7.C1810h;
import q7.C1811i;
import q7.C1824w;
import q7.C1825x;
import q7.G;
import r7.f;
import u7.C2042a;
import u7.e;
import u7.i;
import u7.j;
import u7.m;
import u7.p;
import u7.r;
import u7.s;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/handler/ChatCommandHandlerV2;", "Lcom/stepos/agentframework/adapter/bff/handler/IBffCommandHandler;", AppAgent.CONSTRUCT, "()V", "Lr7/f;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", "cacheBean", "LC7/r;", "handle", "(Lr7/f;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/CacheBean;)V", "Companion", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatCommandHandlerV2 implements IBffCommandHandler {
    private static final String TAG = "BFF-ChatCommandHandlerV2";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentTaskStateNotification$State.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.stepos.agentframework.adapter.bff.handler.IBffCommandHandler
    public void handle(f head, ByteString bodyRaw, CacheBean cacheBean) {
        String str;
        int i;
        boolean z10;
        FunctionCall functionCall;
        String str2;
        FunctionCall functionCall2;
        String strU;
        j jVar;
        FunctionCall functionCall3;
        k.f(head, "head");
        k.f(bodyRaw, "bodyRaw");
        LogUtilKt.getLogger().d(TAG, "handle cacheBean sendId: " + (cacheBean != null ? cacheBean.getSendId() : null) + ", chatRequestInfo: " + (cacheBean != null ? cacheBean.getChatRequestInfo() : null));
        if (cacheBean == null || cacheBean.getChatRequestInfo() == null) {
            return;
        }
        e eVarW = e.W(bodyRaw);
        LogUtilKt.getLogger().d(TAG, a.n("receive_content command: ", head.T(), ", response: ", ExtKt.toJson(eVarW)));
        ArrayList arrayList = new ArrayList();
        String strL = "";
        if (eVarW.U()) {
            String strQ = eVarW.Q();
            k.e(strQ, "getSessionId(...)");
            str = strQ;
        } else {
            str = "";
        }
        if (eVarW.T()) {
            m mVarO = eVarW.O();
            long jB0 = mVarO.b0();
            LogUtilKt.getLogger().d(TAG, "receive_content ack requestId: " + jB0 + ", hasStartAgentAck: " + mVarO.i0() + ", hasSendInputAck: " + mVarO.h0() + ", hasCancelAck: " + mVarO.e0());
            if (jB0 != cacheBean.getChatRequestInfo().h) {
                return;
            }
            int iY = mVarO.Y();
            String strZ = mVarO.Z();
            LogUtilKt.getLogger().d(TAG, androidx.constraintlayout.core.dsl.a.c(iY, "receive_content errorCode: ", ", errorMsg: ", strZ));
            if (iY != 0) {
                if (mVarO.i0()) {
                    LogUtilKt.getLogger().e(TAG, "receive_content startAgentAck failed");
                    IDataCallback iDataCallback = cacheBean.getCallback().get();
                    if (iDataCallback != null) {
                        String strB0 = head.b0();
                        k.e(strB0, "getMsgId(...)");
                        iDataCallback.onError(strB0, iY, strZ);
                        return;
                    }
                    return;
                }
                if (mVarO.h0()) {
                    LogUtilKt.getLogger().e(TAG, "receive_content sendInputAck failed");
                    return;
                }
                if (mVarO.e0()) {
                    LogUtilKt.getLogger().e(TAG, "receive_content cancelAck failed, reason: " + mVarO.W().I());
                    return;
                }
                return;
            }
            if (!mVarO.i0()) {
                if (mVarO.h0()) {
                    LogUtilKt.getLogger().i(TAG, "receive_content sendInputAck success");
                    return;
                } else {
                    if (mVarO.e0()) {
                        LogUtilKt.getLogger().i(TAG, "receive_content cancelAck success");
                        return;
                    }
                    return;
                }
            }
            p pVarD0 = mVarO.d0();
            long jW = pVarD0.W();
            String strR = pVarD0.R();
            String strP = pVarD0.P();
            ILogger logger = LogUtilKt.getLogger();
            StringBuilder sb = new StringBuilder("receive_content startAgentAck sessionId: ");
            sb.append((Object) str);
            sb.append(", taskId: ");
            sb.append(jW);
            logger.i(TAG, androidx.appfunctions.metadata.a.p(sb, ", agentName: ", strR, ", agentDescription: ", strP));
            cacheBean.getChatRequestInfo().i = str;
            cacheBean.getChatRequestInfo().e = str;
            return;
        }
        if (!eVarW.V()) {
            LogUtilKt.getLogger().e(TAG, "UnSupport Protocol Buffer");
            return;
        }
        r rVarS = eVarW.S();
        LogUtilKt.getLogger().i(TAG, "receive_content task sessionId: " + ((Object) str) + ", timestamp: " + rVarS.i0());
        String strB02 = rVarS.b0();
        k.e(strB02, "getId(...)");
        if (str.length() == 0) {
            return;
        }
        if (str.equals(cacheBean.getChatRequestInfo().i) || str.equals(cacheBean.getChatRequestInfo().e)) {
            if (rVarS.l0()) {
                j jVarE0 = rVarS.e0();
                if (jVarE0.a0()) {
                    C1808f c1808fS = jVarE0.S();
                    String strS = c1808fS.S();
                    functionCall2 = null;
                    for (G g : c1808fS.R()) {
                        boolean zD0 = g.d0();
                        LogUtilKt.getLogger().d(TAG, "receive_content task part role: " + strS + ", thought: " + zD0);
                        if (g.i0()) {
                            String strB03 = g.b0();
                            LogUtilKt.getLogger().d(TAG, "receive_content task content text: " + strB03);
                            if (!zD0) {
                                k.c(strB03);
                                arrayList.add(new C0260g(strB03));
                                jVar = jVarE0;
                            }
                        } else {
                            if (g.f0()) {
                                C1810h c1810hY = g.Y();
                                String strO = c1810hY.O();
                                String strQ2 = c1810hY.Q();
                                Struct structM = c1810hY.S() ? c1810hY.M() : null;
                                ILogger logger2 = LogUtilKt.getLogger();
                                jVar = jVarE0;
                                StringBuilder sbW = a.w("receive_content task functionCall id: ", strO, ", name: ", strQ2, ", args: ");
                                sbW.append(structM);
                                logger2.d(TAG, sbW.toString());
                                functionCall3 = new FunctionCall(null, null, structM, strQ2, null, null, null, null, null, null, strO, null, 3059, null);
                            } else {
                                jVar = jVarE0;
                                if (g.g0()) {
                                    C1811i c1811iZ = g.Z();
                                    String strN = c1811iZ.N();
                                    String strP2 = c1811iZ.P();
                                    Struct structR = c1811iZ.S() ? c1811iZ.R() : null;
                                    ILogger logger3 = LogUtilKt.getLogger();
                                    StringBuilder sbW2 = a.w("receive_content task functionResponse id: ", strN, ", name: ", strP2, ", functionResponseSub: ");
                                    sbW2.append(structR);
                                    logger3.d(TAG, sbW2.toString());
                                    functionCall3 = new FunctionCall(null, null, structR, strP2, null, null, null, null, null, null, strN, null, 3059, null);
                                } else if (g.e0()) {
                                    C1809g c1809gX = g.X();
                                    String strS2 = c1809gX.S();
                                    String strO2 = c1809gX.O();
                                    String strQ3 = c1809gX.Q();
                                    ILogger logger4 = LogUtilKt.getLogger();
                                    StringBuilder sbW3 = a.w("receive_content task fileData uri: ", strS2, ", name: ", strO2, ", MIME: ");
                                    sbW3.append(strQ3);
                                    logger4.i(TAG, sbW3.toString());
                                    arrayList.add(ChatContentExtKt.toChatContent(c1809gX));
                                }
                            }
                            functionCall2 = functionCall3;
                            jVarE0 = jVar;
                        }
                        jVarE0 = jVar;
                    }
                } else {
                    functionCall2 = null;
                }
                j jVar2 = jVarE0;
                i = 0;
                boolean zX = jVar2.X();
                boolean Z10 = jVar2.Z();
                if (jVar2.b0()) {
                    strU = jVar2.U();
                    k.e(strU, "getFinishReason(...)");
                } else {
                    strU = "";
                }
                long jY = jVar2.d0() ? jVar2.Y() : -1L;
                Struct structW = jVar2.c0() ? jVar2.W() : null;
                ILogger logger5 = LogUtilKt.getLogger();
                StringBuilder sb2 = new StringBuilder("receive_content task llmResponse partial: ");
                sb2.append(zX);
                sb2.append(", turnComplete: ");
                sb2.append(Z10);
                sb2.append(", finishReason: ");
                a.y(jY, strU, ", sequenceIndex: ", sb2);
                sb2.append(", metadata: ");
                sb2.append(structW);
                logger5.d(TAG, sb2.toString());
                z10 = Z10;
                functionCall = functionCall2;
            } else {
                i = 0;
                if (rVarS.j0()) {
                    C2042a c2042aZ = rVarS.Z();
                    AgentTaskStateNotification$State agentTaskStateNotification$StateN = c2042aZ.N();
                    String strL2 = c2042aZ.P() ? c2042aZ.L() : "";
                    boolean z11 = agentTaskStateNotification$StateN == AgentTaskStateNotification$State.STATE_COMPLETED || agentTaskStateNotification$StateN == AgentTaskStateNotification$State.STATE_INTERRUPTED;
                    int i6 = WhenMappings.$EnumSwitchMapping$0[agentTaskStateNotification$StateN.ordinal()];
                    if (i6 == 1 || i6 == 2 || i6 == 3 || i6 != 4) {
                        AgentTaskState[] agentTaskStateArr = AgentTaskState.f3539a;
                    } else {
                        AgentTaskState[] agentTaskStateArr2 = AgentTaskState.f3539a;
                    }
                    LogUtilKt.getLogger().d(TAG, "receive_content task agentTaskState state: " + agentTaskStateNotification$StateN + ", details: " + strL2);
                    z10 = z11;
                } else {
                    if (rVarS.k0()) {
                        i iVarD0 = rVarS.d0();
                        InputMessageStateNotification$State inputMessageStateNotification$StateN = iVarD0.N();
                        if (iVarD0.P()) {
                            strL = iVarD0.L();
                            k.e(strL, "getDetails(...)");
                        }
                        LogUtilKt.getLogger().d(TAG, "receive_content task inputMessageState state: " + inputMessageStateNotification$StateN + ", details: " + strL);
                        return;
                    }
                    if (rVarS.n0()) {
                        s sVarH0 = rVarS.h0();
                        int iJ = sVarH0.J();
                        String strL3 = sVarH0.L();
                        LogUtilKt.getLogger().e(TAG, androidx.constraintlayout.core.dsl.a.c(iJ, "receive_content task taskError errorCode: ", ", errorMsg: ", strL3));
                        IDataCallback iDataCallback2 = cacheBean.getCallback().get();
                        if (iDataCallback2 != null) {
                            String strB04 = head.b0();
                            k.e(strB04, "getMsgId(...)");
                            iDataCallback2.onError(strB04, iJ, strL3);
                            return;
                        }
                        return;
                    }
                    if (rVarS.m0()) {
                        C1825x c1825xF0 = rVarS.f0();
                        String strM = c1825xF0.M();
                        k.e(strM, "getSessionId(...)");
                        if (c1825xF0.O()) {
                            C1824w c1824wL = c1825xF0.L();
                            LogSender logSenderU = c1824wL.U();
                            LogLevel logLevelS = c1824wL.S();
                            String strP3 = c1824wL.P();
                            long jW2 = c1824wL.W();
                            LogUtilKt.getLogger().d(TAG, "receive_content task logNotification chatId: " + ((Object) strM) + ", sender: " + logSenderU + ", level: " + logLevelS + ", content: " + strP3 + ", timestamp: " + jW2);
                            return;
                        }
                        return;
                    }
                    z10 = false;
                }
                functionCall = null;
            }
            LogUtilKt.getLogger().i(TAG, "receive_content chatId: " + ((Object) str) + ", msgId: " + ((Object) strB02) + ", isFinish: " + z10 + ", sendId: " + head.b0());
            IDataCallback iDataCallback3 = cacheBean.getCallback().get();
            if (iDataCallback3 != null) {
                String strB05 = head.b0();
                k.e(strB05, "getMsgId(...)");
                l chatRequestInfo = cacheBean.getChatRequestInfo();
                String str3 = (chatRequestInfo == null || (str2 = chatRequestInfo.f1364a) == null) ? "" : str2;
                l chatRequestInfo2 = cacheBean.getChatRequestInfo();
                iDataCallback3.onDataReceived(strB05, new V4.k(arrayList, "assistant", str, "text", null, str3, null, 1, z10, chatRequestInfo2 != null ? Integer.valueOf(chatRequestInfo2.h) : null, Integer.valueOf(i), strB02, null, functionCall, 1466753008));
            }
        }
    }
}
