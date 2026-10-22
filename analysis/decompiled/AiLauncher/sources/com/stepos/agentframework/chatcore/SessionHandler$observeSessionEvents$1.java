package com.stepos.agentframework.chatcore;

import Ua.M;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.CronSessionBinder;
import com.stepos.agentframework.chatcore.session.L0;
import com.stepos.agentframework.chatcore.session.ToolDedupSignature;
import com.stepos.agentframework.chatcore.session.X;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.session.e1;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import s4.C5442c;
import u4.AgentMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$observeSessionEvents$1", f = "SessionHandler.kt", l = {835}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$observeSessionEvents$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession $currentSession;
    int label;
    final /* synthetic */ SessionHandler this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ AgentSession $currentSession;
        final /* synthetic */ SessionHandler this$0;

        public a(SessionHandler sessionHandler, AgentSession agentSession) {
            this.this$0 = sessionHandler;
            this.$currentSession = agentSession;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(L0 l02, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            InterfaceC1848c chatView;
            InterfaceC1848c chatView2;
            InterfaceC1848c chatView3;
            InterfaceC1848c chatView4;
            InterfaceC1848c chatView5;
            InterfaceC1848c chatView6;
            InterfaceC1848c chatView7;
            InterfaceC1848c chatView8;
            InterfaceC1848c chatView9;
            AgentSession.h sessionCreatedCallback;
            InterfaceC1848c chatView10;
            InterfaceC1848c chatView11;
            InterfaceC1848c chatView12;
            if (l02 instanceof L0.MessageUpsert) {
                L0.MessageUpsert messageUpsert = (L0.MessageUpsert) l02;
                if (this.this$0.c1(messageUpsert.getMessage())) {
                    this.this$0.p1(messageUpsert.getMessage());
                    return Y8.t.f7040a;
                }
                if (this.this$0.g2(messageUpsert.getMessage())) {
                    this.this$0.p1(messageUpsert.getMessage());
                    return Y8.t.f7040a;
                }
                CronSessionBinder cronSessionBinder = CronSessionBinder.INSTANCE;
                String sessionId = messageUpsert.getMessage().getSessionId();
                if (sessionId.length() == 0) {
                    String sessionId2 = messageUpsert.getSessionId();
                    sessionId = sessionId2 != null ? sessionId2 : "";
                }
                cronSessionBinder.j(sessionId, messageUpsert.getMessage());
                this.this$0.s2(messageUpsert);
                C5442c.o(C5442c.INSTANCE, messageUpsert.getMessage().getTraceId(), Q.f(Y8.j.a("chatMessage", messageUpsert.getMessage())), null, "SessionHandler.MessageUpsert", 4, null);
                this.this$0.getSessionCallback().a(messageUpsert.getMessage());
                this.this$0.U1(messageUpsert.getMessage());
                InterfaceC1848c chatView13 = this.this$0.getChatView();
                boolean zT3 = this.this$0.T3(messageUpsert.getMessage());
                if (chatView13 == null || !zT3) {
                    this.this$0.p1(messageUpsert.getMessage());
                    if (chatView13 == null && zT3) {
                        this.this$0.r2(messageUpsert.getMessage(), "MessageUpsert");
                        this.this$0.z2("MessageUpsert", messageUpsert.getMessage());
                    }
                } else {
                    chatView13.r(messageUpsert.getMessage());
                }
                Y8.t tVar = Y8.t.f7040a;
            } else {
                if (l02 instanceof L0.ToolMessageUpsert) {
                    L0.ToolMessageUpsert toolMessageUpsert = (L0.ToolMessageUpsert) l02;
                    if (!this.this$0.c1(toolMessageUpsert.getMessage()) && !this.this$0.g2(toolMessageUpsert.getMessage())) {
                        if (this.this$0.toolUpsertDedupCache.r(toolMessageUpsert.getMessage().getMessageId(), ToolDedupSignature.INSTANCE.b(toolMessageUpsert.getMessage()))) {
                            return Y8.t.f7040a;
                        }
                        CronSessionBinder cronSessionBinder2 = CronSessionBinder.INSTANCE;
                        String sessionId3 = toolMessageUpsert.getMessage().getSessionId();
                        if (sessionId3.length() == 0 && (sessionId3 = toolMessageUpsert.getSessionId()) == null) {
                            sessionId3 = "";
                        }
                        cronSessionBinder2.j(sessionId3, toolMessageUpsert.getMessage());
                        C5442c.o(C5442c.INSTANCE, toolMessageUpsert.getMessage().getTraceId(), kotlin.collections.a.m(Y8.j.a("sessionId", toolMessageUpsert.getSessionId()), Y8.j.a("messageId", toolMessageUpsert.getMessage().getMessageId()), Y8.j.a("status", toolMessageUpsert.getMessage().getStatus().name())), null, "SessionHandler.ToolMessageUpsert", 4, null);
                        C4148a.d(this.this$0.TAG, "onEvent ToolMessageUpsert messageId:" + toolMessageUpsert.getMessage().getMessageId() + " sessionId:" + toolMessageUpsert.getSessionId(), false, 4, null);
                        List<AgentMessage> listI = toolMessageUpsert.getMessage().i();
                        SessionHandler sessionHandler = this.this$0;
                        Iterator<T> it = listI.iterator();
                        while (it.hasNext()) {
                            List<AgentTool> listG = ((AgentMessage) it.next()).g();
                            if (listG != null) {
                                for (AgentTool agentTool : listG) {
                                    sessionHandler.getToolCallBack().a(toolMessageUpsert.getMessage(), agentTool);
                                    String sessionId4 = toolMessageUpsert.getSessionId();
                                    if (sessionId4 == null) {
                                        sessionId4 = "";
                                    }
                                    e1.a(sessionId4, toolMessageUpsert.getMessage(), agentTool);
                                    AppUIData appUIData = agentTool.getAppUIData();
                                    if (appUIData != null && appUIData.isFixed() && sessionHandler.T3(toolMessageUpsert.getMessage()) && (chatView12 = sessionHandler.getChatView()) != null) {
                                        chatView12.a(toolMessageUpsert.getMessage(), appUIData);
                                        Y8.t tVar2 = Y8.t.f7040a;
                                    }
                                }
                                Y8.t tVar3 = Y8.t.f7040a;
                            }
                        }
                        if (this.this$0.T3(toolMessageUpsert.getMessage())) {
                            InterfaceC1848c chatView14 = this.this$0.getChatView();
                            if (chatView14 != null) {
                                chatView14.n(toolMessageUpsert.getMessage(), false);
                            } else {
                                this.this$0.r2(toolMessageUpsert.getMessage(), "ToolMessageUpsert");
                                this.this$0.z2("ToolMessageUpsert", toolMessageUpsert.getMessage());
                            }
                        }
                        Y8.t tVar4 = Y8.t.f7040a;
                    }
                    return Y8.t.f7040a;
                }
                if (l02 instanceof L0.MessageReplace) {
                    L0.MessageReplace messageReplace = (L0.MessageReplace) l02;
                    if (this.this$0.blockedMessageIds.contains(messageReplace.getMessage().getMessageId()) || this.this$0.blockedMessageIds.contains(messageReplace.getOldMessageId())) {
                        this.this$0.k3(messageReplace.getOldMessageId());
                        this.this$0.k3(messageReplace.getMessage().getMessageId());
                        return Y8.t.f7040a;
                    }
                    C5442c.o(C5442c.INSTANCE, messageReplace.getMessage().getTraceId(), kotlin.collections.a.m(Y8.j.a("sessionId", messageReplace.getSessionId()), Y8.j.a("oldMessageId", messageReplace.getOldMessageId()), Y8.j.a("newMessageId", messageReplace.getMessage().getMessageId()), Y8.j.a("status", messageReplace.getMessage().getStatus().name()), Y8.j.a("isVariantSwitch", C4109a.a(messageReplace.getIsVariantSwitch()))), null, "SessionHandler.MessageReplace", 4, null);
                    C4148a.d(this.this$0.TAG, "onEvent MessageReplace oldMessageId:" + messageReplace.getOldMessageId() + " newMessageId:" + messageReplace.getMessage().getMessageId() + " sessionId:" + messageReplace.getSessionId(), false, 4, null);
                    if (this.this$0.T3(messageReplace.getMessage())) {
                        InterfaceC1848c chatView15 = this.this$0.getChatView();
                        if (chatView15 == null) {
                            this.this$0.r2(messageReplace.getMessage(), "MessageReplace");
                        } else if (messageReplace.getIsVariantSwitch()) {
                            chatView15.R(messageReplace.getMessage(), messageReplace.getOldMessageId());
                        } else {
                            chatView15.I(messageReplace.getMessage(), messageReplace.getOldMessageId());
                        }
                    }
                    Y8.t tVar5 = Y8.t.f7040a;
                } else if (l02 instanceof L0.MessageRemove) {
                    L0.MessageRemove messageRemove = (L0.MessageRemove) l02;
                    C5442c.o(C5442c.INSTANCE, messageRemove.getMessage().getTraceId(), kotlin.collections.a.m(Y8.j.a("sessionId", messageRemove.getSessionId()), Y8.j.a("messageId", messageRemove.getMessage().getMessageId())), null, "SessionHandler.MessageRemove", 4, null);
                    C4148a.d(this.this$0.TAG, "onEvent MessageRemove messageId:" + messageRemove.getMessage().getMessageId() + " sessionId:" + messageRemove.getSessionId(), false, 4, null);
                    if (this.this$0.T3(messageRemove.getMessage()) && (chatView11 = this.this$0.getChatView()) != null) {
                        chatView11.K(messageRemove.getMessage().getMessageId());
                        Y8.t tVar6 = Y8.t.f7040a;
                    }
                    Y8.t tVar7 = Y8.t.f7040a;
                } else if (l02 instanceof L0.ConversationChanged) {
                    String str = this.this$0.TAG;
                    L0.ConversationChanged conversationChanged = (L0.ConversationChanged) l02;
                    String sessionId5 = conversationChanged.getSessionId();
                    int size = conversationChanged.b().size();
                    w4.e title = conversationChanged.getTitle();
                    C4148a.k(str, "onEvent ConversationChanged sessionId:" + sessionId5 + " messages:" + size + " title:" + (title != null ? title.getTitle() : null), false, 4, null);
                    String sessionId6 = conversationChanged.getSessionId();
                    if (sessionId6 == null || sessionId6.length() == 0) {
                        InterfaceC1848c chatView16 = this.this$0.getChatView();
                        if (chatView16 != null) {
                            chatView16.O();
                            Y8.t tVar8 = Y8.t.f7040a;
                        }
                    } else {
                        InterfaceC1848c chatView17 = this.this$0.getChatView();
                        if (chatView17 != null) {
                            chatView17.F(conversationChanged.getTitle(), conversationChanged.b());
                            Y8.t tVar9 = Y8.t.f7040a;
                        }
                    }
                } else if (l02 instanceof L0.ConversationMessagesCleared) {
                    L0.ConversationMessagesCleared conversationMessagesCleared = (L0.ConversationMessagesCleared) l02;
                    C5442c.l(C5442c.INSTANCE, null, "event", Q.f(Y8.j.a("sessionId", conversationMessagesCleared.getSessionId())), null, "SessionHandler.ConversationMessagesCleared", 8, null);
                    String sessionId7 = conversationMessagesCleared.getSessionId();
                    String str2 = sessionId7 != null ? sessionId7 : "";
                    if (str2.length() == 0) {
                        return Y8.t.f7040a;
                    }
                    AgentSession.AgentConversation topConversation = this.$currentSession.getTopConversation();
                    String sessionId8 = topConversation.getSessionId();
                    if (sessionId8.length() == 0) {
                        sessionId8 = topConversation.getTempSessionId();
                    }
                    if (kotlin.jvm.internal.p.d(sessionId8, str2)) {
                        C4148a.k(this.this$0.TAG, "onEvent ConversationMessagesCleared sessionId:" + str2, false, 4, null);
                        InterfaceC1848c chatView18 = this.this$0.getChatView();
                        if (chatView18 != null) {
                            chatView18.m(str2);
                            Y8.t tVar10 = Y8.t.f7040a;
                        }
                    }
                    Y8.t tVar11 = Y8.t.f7040a;
                } else if (l02 instanceof L0.TaskPlanEvent) {
                    L0.TaskPlanEvent taskPlanEvent = (L0.TaskPlanEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent TaskPlanEvent sessionId:" + taskPlanEvent.getSessionId(), false, 4, null);
                    this.this$0.getTaskCallback().a(taskPlanEvent.getTaskPlan());
                    Y8.t tVar12 = Y8.t.f7040a;
                } else if (l02 instanceof L0.TaskUpdateEvent) {
                    L0.TaskUpdateEvent taskUpdateEvent = (L0.TaskUpdateEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent TaskUpdateEvent sessionId:" + taskUpdateEvent.getSessionId() + " taskId:" + taskUpdateEvent.getTask().getId(), false, 4, null);
                    X taskCallback = this.this$0.getTaskCallback();
                    String sessionId9 = taskUpdateEvent.getSessionId();
                    taskCallback.d(sessionId9 != null ? sessionId9 : "", taskUpdateEvent.getTask());
                    Y8.t tVar13 = Y8.t.f7040a;
                } else if (l02 instanceof L0.TaskCompleteEvent) {
                    L0.TaskCompleteEvent taskCompleteEvent = (L0.TaskCompleteEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent TaskCompleteEvent sessionId:" + taskCompleteEvent.getSessionId() + " planId:" + taskCompleteEvent.getTask().getPlan_id(), false, 4, null);
                    X taskCallback2 = this.this$0.getTaskCallback();
                    String sessionId10 = taskCompleteEvent.getSessionId();
                    taskCallback2.c(sessionId10 != null ? sessionId10 : "", taskCompleteEvent.getTask());
                    Y8.t tVar14 = Y8.t.f7040a;
                } else if (l02 instanceof L0.TaskFailedEvent) {
                    L0.TaskFailedEvent taskFailedEvent = (L0.TaskFailedEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent TaskFailedEvent sessionId:" + taskFailedEvent.getSessionId() + " planId:" + taskFailedEvent.getTask().getPlan_id() + " code:" + taskFailedEvent.getTask().getCode(), false, 4, null);
                    X taskCallback3 = this.this$0.getTaskCallback();
                    String sessionId11 = taskFailedEvent.getSessionId();
                    taskCallback3.e(sessionId11 != null ? sessionId11 : "", taskFailedEvent.getTask());
                    Y8.t tVar15 = Y8.t.f7040a;
                } else if (l02 instanceof L0.ModerationEvent) {
                    L0.ModerationEvent moderationEvent = (L0.ModerationEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent ModerationEvent sessionId:" + moderationEvent.getSessionId() + " decision:" + moderationEvent.getModeration().getDecision() + " interrupted:" + moderationEvent.getModeration().getInterrupted() + " channelMessageId:" + moderationEvent.getModeration().getChannelMessageId(), false, 4, null);
                    SessionHandler sessionHandler2 = this.this$0;
                    RunBlockedEvent runBlockedEventG4 = sessionHandler2.g4(moderationEvent.getModeration());
                    String sessionId12 = moderationEvent.getSessionId();
                    sessionHandler2.X1(runBlockedEventG4, sessionId12 != null ? sessionId12 : "", moderationEvent.getIdempotencyKey(), moderationEvent.getModeration());
                    if (moderationEvent.getModeration().getInterrupted() && this.this$0.S3(moderationEvent.getSessionId()) && (chatView10 = this.this$0.getChatView()) != null) {
                        chatView10.N();
                        Y8.t tVar16 = Y8.t.f7040a;
                    }
                    Y8.t tVar17 = Y8.t.f7040a;
                } else if (l02 instanceof L0.NoMessageIdResponseEvent) {
                    L0.NoMessageIdResponseEvent noMessageIdResponseEvent = (L0.NoMessageIdResponseEvent) l02;
                    C4148a.u(this.this$0.TAG, "onEvent NoMessageIdResponseEvent sessionId:" + noMessageIdResponseEvent.getSessionId() + " content:" + noMessageIdResponseEvent.getContent(), false, 4, null);
                    AgentSession.c bizCallback = (AgentSession.c) this.this$0.pendingBizCallbacks.remove(noMessageIdResponseEvent.getPairId());
                    if (bizCallback == null) {
                        bizCallback = this.this$0.getBizCallback();
                    }
                    bizCallback.onSuccess(noMessageIdResponseEvent.getContent());
                    Y8.t tVar18 = Y8.t.f7040a;
                } else if (l02 instanceof L0.ConversationDeleted) {
                    String str3 = this.this$0.TAG;
                    L0.ConversationDeleted conversationDeleted = (L0.ConversationDeleted) l02;
                    String sessionId13 = conversationDeleted.getSessionId();
                    w4.e title2 = conversationDeleted.getTitle();
                    C4148a.k(str3, "onEvent ConversationDeleted sessionId:" + sessionId13 + " title:" + (title2 != null ? title2.getTitle() : null), false, 4, null);
                    this.this$0.t1(conversationDeleted.getSessionId());
                    Y8.t tVar19 = Y8.t.f7040a;
                } else if (l02 instanceof L0.ConversationNameChanged) {
                    String str4 = this.this$0.TAG;
                    L0.ConversationNameChanged conversationNameChanged = (L0.ConversationNameChanged) l02;
                    String sessionId14 = conversationNameChanged.getSessionId();
                    w4.e title3 = conversationNameChanged.getTitle();
                    C4109a.f(C4148a.k(str4, "onEvent ConversationNameChanged sessionId:" + sessionId14 + " title:" + (title3 != null ? title3.getTitle() : null), false, 4, null));
                } else if (l02 instanceof L0.SessionCreated) {
                    L0.SessionCreated sessionCreated = (L0.SessionCreated) l02;
                    C4148a.k(this.this$0.TAG, "onEvent SessionCreated tempSessionId:" + sessionCreated.getTempSessionId() + " createdSessionId:" + sessionCreated.getCreatedSessionId(), false, 4, null);
                    if ((this.this$0.S3(sessionCreated.getCreatedSessionId()) || this.this$0.S3(sessionCreated.getTempSessionId())) && (sessionCreatedCallback = this.this$0.getSessionCreatedCallback()) != null) {
                        sessionCreatedCallback.a(sessionCreated.getCreatedSessionId());
                        Y8.t tVar20 = Y8.t.f7040a;
                    }
                    Y8.t tVar21 = Y8.t.f7040a;
                } else if (l02 instanceof L0.ErrorEvent) {
                    L0.ErrorEvent errorEvent = (L0.ErrorEvent) l02;
                    C5442c.INSTANCE.k(null, "event", kotlin.collections.a.m(Y8.j.a("sessionId", errorEvent.getSessionId()), Y8.j.a("code", C4109a.f(errorEvent.getError().getCode())), Y8.j.a("message", errorEvent.getError().getMessage())), ExifInterface.LONGITUDE_EAST, "SessionHandler.ErrorEvent");
                    C4148a.u(this.this$0.TAG, "onEvent ErrorEvent sessionId:" + errorEvent.getSessionId() + " code:" + errorEvent.getError().getCode() + " message:" + errorEvent.getError().getMessage(), false, 4, null);
                    if (La.H.g0(errorEvent.getError().getMessage(), "upstream_offline_timeout", false, 2, null) && this.this$0.S3(errorEvent.getSessionId()) && (chatView9 = this.this$0.getChatView()) != null) {
                        chatView9.E();
                        Y8.t tVar22 = Y8.t.f7040a;
                    }
                    if (this.this$0.S3(errorEvent.getSessionId()) && (chatView8 = this.this$0.getChatView()) != null) {
                        chatView8.N();
                        Y8.t tVar23 = Y8.t.f7040a;
                    }
                    Y8.t tVar24 = Y8.t.f7040a;
                } else if (l02 instanceof L0.SendAckEvent) {
                    L0.SendAckEvent sendAckEvent = (L0.SendAckEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent SendAckEvent sessionId:" + sendAckEvent.getSessionId() + " success:" + sendAckEvent.getSuccess() + " ids:" + sendAckEvent.d(), false, 4, null);
                    if (this.this$0.S3(sendAckEvent.getSessionId())) {
                        this.this$0.getSessionCallback().b(sendAckEvent.getSuccess(), sendAckEvent.getCode(), sendAckEvent.getMessage());
                        InterfaceC1848c chatView19 = this.this$0.getChatView();
                        if (chatView19 != null) {
                            chatView19.W(sendAckEvent.d(), sendAckEvent.getSuccess());
                            Y8.t tVar25 = Y8.t.f7040a;
                        }
                    }
                    String sessionId15 = sendAckEvent.getSessionId();
                    if (sessionId15 != null) {
                        String str5 = sessionId15.length() > 0 ? sessionId15 : null;
                        if (str5 != null) {
                            this.this$0.H3(str5, !sendAckEvent.getSuccess());
                            Y8.t tVar26 = Y8.t.f7040a;
                        }
                    }
                    p9.q qVar = this.this$0.cloudSendFailFallback;
                    if (qVar != null) {
                        qVar.invoke(sendAckEvent.d(), sendAckEvent.getSessionId(), C4109a.a(sendAckEvent.getSuccess()));
                        Y8.t tVar27 = Y8.t.f7040a;
                    }
                } else if (l02 instanceof L0.NetworkToastEvent) {
                    L0.NetworkToastEvent networkToastEvent = (L0.NetworkToastEvent) l02;
                    if (this.this$0.S3(networkToastEvent.getSessionId()) && (chatView7 = this.this$0.getChatView()) != null) {
                        chatView7.g(networkToastEvent.getPhase());
                        Y8.t tVar28 = Y8.t.f7040a;
                    }
                    Y8.t tVar29 = Y8.t.f7040a;
                } else if (l02 instanceof L0.COTCollapseEvent) {
                    if (this.this$0.S3(((L0.COTCollapseEvent) l02).getSessionId()) && (chatView6 = this.this$0.getChatView()) != null) {
                        chatView6.q();
                        Y8.t tVar30 = Y8.t.f7040a;
                    }
                    Y8.t tVar31 = Y8.t.f7040a;
                } else if (l02 instanceof L0.CotTimingStart) {
                    L0.CotTimingStart cotTimingStart = (L0.CotTimingStart) l02;
                    if (this.this$0.S3(cotTimingStart.getSessionId()) && (chatView5 = this.this$0.getChatView()) != null) {
                        chatView5.h(cotTimingStart.getStartAtMs());
                        Y8.t tVar32 = Y8.t.f7040a;
                    }
                    Y8.t tVar33 = Y8.t.f7040a;
                } else if (l02 instanceof L0.CotTimingTick) {
                    L0.CotTimingTick cotTimingTick = (L0.CotTimingTick) l02;
                    if (this.this$0.S3(cotTimingTick.getSessionId()) && (chatView4 = this.this$0.getChatView()) != null) {
                        chatView4.C(cotTimingTick.getElapsedMs());
                        Y8.t tVar34 = Y8.t.f7040a;
                    }
                    Y8.t tVar35 = Y8.t.f7040a;
                } else if (l02 instanceof L0.CotTimingEnd) {
                    L0.CotTimingEnd cotTimingEnd = (L0.CotTimingEnd) l02;
                    if (this.this$0.S3(cotTimingEnd.getSessionId()) && (chatView3 = this.this$0.getChatView()) != null) {
                        chatView3.G(cotTimingEnd.getDurationMs(), cotTimingEnd.getToolCount());
                        Y8.t tVar36 = Y8.t.f7040a;
                    }
                    Y8.t tVar37 = Y8.t.f7040a;
                } else if (l02 instanceof L0.ReconnectPromptEvent) {
                    L0.ReconnectPromptEvent reconnectPromptEvent = (L0.ReconnectPromptEvent) l02;
                    C4148a.k(this.this$0.TAG, "onEvent ReconnectPromptEvent sessionId:" + reconnectPromptEvent.getSessionId() + " roundAlive:" + reconnectPromptEvent.getRoundAlive() + " reason:" + reconnectPromptEvent.getReason(), false, 4, null);
                    if (this.this$0.S3(reconnectPromptEvent.getSessionId())) {
                        InterfaceC1848c chatView20 = this.this$0.getChatView();
                        if (chatView20 != null) {
                            chatView20.s(reconnectPromptEvent.getRoundAlive(), reconnectPromptEvent.getReason());
                            Y8.t tVar38 = Y8.t.f7040a;
                        }
                        if (!reconnectPromptEvent.getRoundAlive() && (chatView2 = this.this$0.getChatView()) != null) {
                            chatView2.N();
                            Y8.t tVar39 = Y8.t.f7040a;
                        }
                    }
                    Y8.t tVar40 = Y8.t.f7040a;
                } else {
                    if (!(l02 instanceof L0.ReconnectPromptDismissEvent)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    L0.ReconnectPromptDismissEvent reconnectPromptDismissEvent = (L0.ReconnectPromptDismissEvent) l02;
                    if (this.this$0.S3(reconnectPromptDismissEvent.getSessionId()) && (chatView = this.this$0.getChatView()) != null) {
                        chatView.U(reconnectPromptDismissEvent.getReason());
                        Y8.t tVar41 = Y8.t.f7040a;
                    }
                    Y8.t tVar42 = Y8.t.f7040a;
                }
            }
            this.this$0.i4();
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$observeSessionEvents$1(AgentSession agentSession, SessionHandler sessionHandler, InterfaceC4014c<? super SessionHandler$observeSessionEvents$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$currentSession = agentSession;
        this.this$0 = sessionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$observeSessionEvents$1(this.$currentSession, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$observeSessionEvents$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<L0> oVarG1 = this.$currentSession.g1();
            a aVar = new a(this.this$0, this.$currentSession);
            this.label = 1;
            if (oVarG1.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
