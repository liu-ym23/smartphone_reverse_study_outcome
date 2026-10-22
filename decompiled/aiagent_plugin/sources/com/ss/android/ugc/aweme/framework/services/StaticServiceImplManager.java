package com.ss.android.ugc.aweme.framework.services;

import com.obric.agent.AgentServiceImpl;
import com.obric.agent.AgentSettingsIDLStub;
import com.obric.agent.AppIntentFeedbackImpl;
import com.obric.agent.AppIntentIDLStub;
import com.obric.agent.AppIntentIPCLifecycleImpl;
import com.obric.agent.FlowIntentActionServiceImpl;
import com.obric.agent.IntentTraceServiceImpl;
import com.obric.agent.MessageIDLStub;
import com.obric.agent.MessageObserverRegistryImpl;
import com.obric.agent.auth.AgentAuthServiceImpl;
import com.obric.agent.autoaction.AutoActionServiceImpl;
import com.obric.agent.complextask.ComplexTaskServiceImpl;
import com.obric.agent.entity.EntityManagerImpl;
import com.obric.agent.entitysync.AppEntityMessageExtProvider;
import com.obric.agent.message.DoraMessageExtProvider;
import com.obric.agent.message.MessageCollectServiceImpl;
import com.obric.agent.omnimodel.OmniModelServiceImpl;
import com.obric.agent.permission.PermissionServiceImpl;
import com.obric.agent.trace.IntentMetricsServiceImpl;
import com.obric.agent.trace.omni.OmniReportServiceImpl;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.account.AccountServiceImpl;
import com.obric.aiagent.apm.ApmImpl;
import com.obric.aiagent.apm.impl.ALogDependImpl;
import com.obric.aiagent.apm.impl.ALogSecureDependImpl;
import com.obric.aiagent.apm.impl.SysLogDependImpl;
import com.obric.aiagent.applog.AppLogImpl;
import com.obric.aiagent.applog.CommonParamsImpl;
import com.obric.aiagent.applog.impl.TraceDependImpl;
import com.obric.aiagent.executionengine.AgentExecutionEngineImpl;
import com.obric.aiagent.executionengine.capabilitymanager.matcher.ActionMatcherService;
import com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManagerService;
import com.obric.aiagent.executionengine.capabilitymanager.publish.RegistrationManager;
import com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl;
import com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl;
import com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskExecutionApiImpl;
import com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskListenerApiImpl;
import com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl;
import com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl;
import com.obric.aiagent.executionengine.scheduler.impl.EventManagerImpl;
import com.obric.aiagent.executionengine.scheduler.impl.JobManagerImpl;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.AppFunctionSettingsServiceImpl;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.AppFunctionInvoker;
import com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.UriFileAccessMiddleman;
import com.obric.aiagent.interaction.impl.PlatformApiIDLSPIImpl;
import com.obric.aiagent.interaction.impl.PlatformApiImpl;
import com.obric.aiagent.ipc.AgentIpcManagerImpl;
import com.obric.aiagent.ipc.IPCIDLChecker;
import com.obric.aiagent.ipc.assistant.AssistantIDLStub;
import com.obric.aiagent.ipc.idl.FileIDLStubImpl;
import com.obric.aiagent.network.AgentNetworkIDLSPIImpl;
import com.obric.aiagent.performance.MemoryReportServiceImpl;
import com.obric.aiagent.performance.PerformanceMonitorImpl;
import com.obric.aiagent.plugin_impl.PluginAppContextImpl;
import com.obric.aiagent.plugin_impl.autoaction.app.AutoActionHostResProviderImpl;
import com.obric.aiagent.plugin_impl.autoaction.assistant_card.AssistCardResProviderImpl;
import com.obric.aiagent.privacy.PrivacyAgreeEvent;
import com.obric.aiagent.privacy.PrivacyServiceImpl;
import com.obric.aiagent.privacy_sec.impl.PrivacyIDLStub;
import com.obric.aiagent.privacy_sec.impl.PrivacyImpl;
import com.obric.aiagent.product.impl.ObricProductImpl;
import com.obric.aiagent.product.platform.impl.rom.CommonRomInfoImpl;
import com.obric.aiagent.security.AiAgentSecurityServiceImpl;
import com.obric.aiagent.skill.credentials.impl.SafetyGuardSkillCredentialService;
import com.obric.aiagent.skill.credentials.impl.lifecycle.LarkCliOVirtLifecycleListener;
import com.obric.aiagent.skill.manager.impl.SkillInstallAttributionServiceImpl;
import com.obric.aiagent.skill.manager.impl.SkillManager;
import com.obric.aiagent.skill.manager.impl.SkillManagerIDLSPIImpl;
import com.obric.aiagent.skill.manager.impl.SkillSettingsServiceImpl;
import com.obric.aiagent.skill.ovirt.impl.OVirt;
import com.obric.aiagent.skill.ovirt.impl.reporting.OVirtReporter;
import com.obric.aiagent.skill.virt.impl.Virt;
import com.obric.aiagent.trace.IPCLifeTrace;
import com.obric.aiagent.trace.TraceReportImpl;
import com.obric.aiagent.ttnet.TTNetFileTransferImpl;
import com.obric.aiagent.ttnet.TTNetImpl;
import com.obric.aiagent.utils.config.FeatureSettingsImpl;
import com.obric.assistant.dm.impl.DialogManagement;
import com.obric.assistant.dm.impl.statemachine.manager.DMStateManagerIDLStub;
import com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl;
import com.obric.assistant.product.StaticCloudConfigImpl;
import com.obric.autoaction.LegacyUIEventListener;
import com.obric.autoaction.OmniTaskStateManagerImpl;
import com.obric.autoaction.app.launcherpage.TaskAppIDLStub;
import com.obric.autoaction.app.launcherpage.automation.AutomationTab;
import com.obric.autoaction.app.launcherpage.discovery.DiscoveryTab;
import com.obric.autoaction.app.launcherpage.donation.DonationImpl;
import com.obric.autoaction.app.launcherpage.history.historydetail.RecordHistoryStepStateListener;
import com.obric.autoaction.app.launcherpage.knowledge.AutoActionTasksImpl;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeAutoActionAgentEventListener;
import com.obric.autoaction.app.launcherpage.module.datasource.NewAddedTimerTaskRecordImpl;
import com.obric.autoaction.app.launcherpage.query.task.spi.EventTaskNlpDependImpl;
import com.obric.autoaction.app.launcherpage.service.impl.AutoTaskImpl;
import com.obric.autoaction.app.launcherpage.shortcut.ShortCutTab;
import com.obric.autoaction.app.notification.AutoActionNotifApiImpl;
import com.obric.autoaction.app.notification.NotifCallUserListernerImpl;
import com.obric.autoaction.foundation.AutoActionAppFoundationImpl;
import com.obric.autoaction.hostbridges.OAutoAIAgentLogging;
import com.obric.autoaction.inittasks.refactor.CleanHeifScreenshotCacheTask;
import com.obric.autoaction.inittasks.refactor.InitAIKernelTask;
import com.obric.autoaction.inittasks.refactor.InitAppListListeneningTask;
import com.obric.autoaction.inittasks.refactor.InitAuthStateTask;
import com.obric.autoaction.inittasks.refactor.InitCardProviderTask;
import com.obric.autoaction.inittasks.refactor.InitFrameWorkUnMuteWhiteListInjectTask;
import com.obric.autoaction.inittasks.refactor.InitIslandTask;
import com.obric.autoaction.inittasks.refactor.InitOmniUploadImageTask;
import com.obric.autoaction.inittasks.refactor.InitSettingTask;
import com.obric.autoaction.inittasks.refactor.InitThermalListeningTask;
import com.obric.autoaction.inittasks.refactor.InitTrackingTask;
import com.obric.autoaction.inittasks.refactor.InitUserReportTask;
import com.obric.autoaction.inittasks.refactor.RemoveDanglingTask;
import com.obric.autoaction.intent.GUIEventListener;
import com.obric.autoaction.presentation.AIAgentEventListener;
import com.obric.autoaction.presentation.AutoActionPresentationApiImpl;
import com.obric.autoaction.presentation.EndOfTaskOpenAppListener;
import com.obric.autoaction.presentation.doubao.AssistCardFinalizer;
import com.obric.autoaction.presentation.doubao.AssistCardTimerTaskUpdateImpl;
import com.obric.autoaction.presentation.doubao.AssistRemoteCardUpdateImpl;
import com.obric.autoaction.presentation.function.FunctionControllerImpl;
import com.obric.autoaction.presentation.function.UIAgentFunctionListener;
import com.obric.autoaction.presentation.input.AssistInputClarifyEndHandler;
import com.obric.autoaction.presentation.input.AssistInputFunctionEventHandler;
import com.obric.autoaction.presentation.input.AssistInputImpl;
import com.obric.autoaction.presentation.input.states.AssistInputAgentStateListener;
import com.obric.autoaction.presentation.input.states.AssistInputStateManagerImpl;
import com.obric.autoaction.presentation.island.donation.DonationTaskStateImpl;
import com.obric.autoaction.presentation.island.state.CallUserStateHandler;
import com.obric.autoaction.presentation.island.state.ClarifyStateHandler;
import com.obric.autoaction.presentation.island.state.FinishStateHandler;
import com.obric.autoaction.presentation.island.state.IslandDialogueModeHandler;
import com.obric.autoaction.presentation.island.state.SetTimerTaskHandler;
import com.obric.autoaction.presentation.island.state.TaskCreateStateHandler;
import com.obric.autoaction.presentation.island.state.TaskOperatingStateHandler;
import com.obric.autoaction.presentation.island.state.UserInterruptStateHandler;
import com.obric.autoaction.presentation.player.AppSecureTipsApiImpl;
import com.obric.autoaction.presentation.provider.OAutoStateProviderUpdateImpl;
import com.obric.autoaction.presentation.widget.AutoAgentEventToWidgetStateImpl;
import com.obric.autoaction.presentation.widget.WidgetStateToUIContext;
import com.obric.autogui.agents.scripted.impl.JSScriptServiceImpl;
import com.obric.autogui.agents.scripted.impl.ScriptFoundationReadyTask;
import com.obric.autogui.agents.stateprovider.AgentStateProviderEventListener;
import com.obric.autogui.agents.vlm.cocreation.OmniLabelingHostBridgeDataSink;
import com.obric.autogui.agents.vlm.cocreation.OmniLabelingUserStopRecorderImpl;
import com.obric.autogui.agents.vlm.models.impl.applist.AutoActionAppListApiImpl;
import com.obric.autogui.agents.vlm.models.impl.request.StandardModelRemoteAgentImpl;
import com.obric.autogui.agents.vlm.models.omni.upload.OmniLabelingFeedbackUploaderImpl;
import com.obric.autogui.biztrack.OperatorBizTrackingListener;
import com.obric.autogui.common.api.space.listener.OperatingSpaceBizStateListeners;
import com.obric.autogui.common.api.space.vd.AutoActionVDimpl;
import com.obric.autogui.database.impl.EventTaskServiceImpl;
import com.obric.autogui.execrecord.AgentExecSpecsDBListenerImpl;
import com.obric.autogui.imagex.ImageXApiImpl;
import com.obric.autogui.ipc.FlowMessageListenerRegister;
import com.obric.autogui.modules.tfmodels.TFLiteModelProvider;
import com.obric.autogui.net.push.PushApiImpl;
import com.obric.autogui.net.status.ObricNetStatusImpl;
import com.obric.autogui.net.ttnet.TTNetNetworkApiImpl;
import com.obric.autogui.net.wschannel.WsChannelApiImpl;
import com.obric.autogui.platforms.router.AOPlatformProvider;
import com.obric.autogui.platforms.tools.computercontrol.StandardCCSpaceSpawner;
import com.obric.autogui.platforms.tools.security.listener.ObricSecurityListenerForAgent;
import com.obric.autogui.session.SessionManagerImpl;
import com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl;
import com.obric.autogui.session.state.AgentOperationStateListener;
import com.obric.autogui.session.state.AutoActionAgentImpl;
import com.obric.autogui.session.state.VirtualDisplayRecordSetBizStateListener;
import com.obric.autogui.userreport.OAppUserReportImpl;
import com.obric.autogui.util.doubao.settings.SettingsViaFlowApiImpl;
import com.obric.autogui.vdplayer.adapter.orchestrator.AgentEventDispatcher;
import com.obric.autogui.vdplayer.adapter.orchestrator.AgentSessionManagerImpl;
import com.obric.autogui.vdplayer.adapter.platform.FeedbackApiImpl;
import com.obric.autogui.vdplayer.adapter.platform.PlatformToolsImpl;
import com.obric.autogui.vdplayer.adapter.platform.VirtualDisplayApiImpl;
import com.obric.capabilitykit.common.intent.BaseAppFuncExecuteIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPauseIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayFromScratchIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayNextIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayPreviousIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlSeekToIntent;
import com.obric.capabilitykit.common.intent.BaseBrowserUseIntent;
import com.obric.capabilitykit.common.intent.BaseCalculatorCalculateIntent;
import com.obric.capabilitykit.common.intent.BaseCalendarShowScheduleIntent;
import com.obric.capabilitykit.common.intent.BaseCameraRotateCameraIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetAuxiliaryLineIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetEVIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetExposureTimeIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFilterIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFlashModeIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFocalIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFocusDistanceIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetISOIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetImageRatioIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetMeteringModeIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetSelfTimerIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetTouchCaptureIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetWBIntent;
import com.obric.capabilitykit.common.intent.BaseCameraStartCaptureIntent;
import com.obric.capabilitykit.common.intent.BaseCameraStartRecordingIntent;
import com.obric.capabilitykit.common.intent.BaseCameraStopCaptureIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSwitchCameraModeIntent;
import com.obric.capabilitykit.common.intent.BaseClockCreateAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockDeleteAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockDeleteCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockPauseCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockResumeCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockSearchAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockSearchCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockStartCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockTurnOffAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockTurnOnAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockUpdateAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.BaseContactsAddToBlocklistIntent;
import com.obric.capabilitykit.common.intent.BaseContactsAddToFavoriteIntent;
import com.obric.capabilitykit.common.intent.BaseContactsCreateIntent;
import com.obric.capabilitykit.common.intent.BaseContactsDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseContactsSearchIntent;
import com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent;
import com.obric.capabilitykit.common.intent.BaseContactsUpdateIntent;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeScreenShareIntent;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeVideoCallIntent;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeVoiceCallIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskGetTaskInfoIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskUpdateTaskIntent;
import com.obric.capabilitykit.common.intent.BaseFilesShowFileIntent;
import com.obric.capabilitykit.common.intent.BaseFinanceSearchStockIntent;
import com.obric.capabilitykit.common.intent.BaseGUIActionIntent;
import com.obric.capabilitykit.common.intent.BaseGUIINITIntent;
import com.obric.capabilitykit.common.intent.BaseGUIReplyIntent;
import com.obric.capabilitykit.common.intent.BaseGUIScreenshotIntent;
import com.obric.capabilitykit.common.intent.BaseMapNaviRouteIntent;
import com.obric.capabilitykit.common.intent.BaseMapSearchPOIIntent;
import com.obric.capabilitykit.common.intent.BaseMapTakeTaxiIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryOperateIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryOperateNewIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryProduceIntent;
import com.obric.capabilitykit.common.intent.BaseMemorySaveDialogueMemoryIntent;
import com.obric.capabilitykit.common.intent.BaseMemorySearchIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesSearchIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesSendIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesShowMessageIntent;
import com.obric.capabilitykit.common.intent.BaseNetEaseCloudMusicSearchIntent;
import com.obric.capabilitykit.common.intent.BaseNotesCreateIntent;
import com.obric.capabilitykit.common.intent.BaseNotesSearchIntent;
import com.obric.capabilitykit.common.intent.BaseNotesShowNoteIntent;
import com.obric.capabilitykit.common.intent.BaseNotesUpdateIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeBookMeetingIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeCheckLoginIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeJumpToLarkUrlIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeKnowledgeAIAuthIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeKnowledgeAIIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeLarkCLICheckLoginIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeLarkCLIEnsureAuthIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchLarkContactInfoByAsrIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchLarkContactInfoByNameIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchMeetingIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSendMessageIntent;
import com.obric.capabilitykit.common.intent.BasePCAppFcEntitySearchIntent;
import com.obric.capabilitykit.common.intent.BasePCCommonGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCDoubaoGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCEntityPoisonLabelIntent;
import com.obric.capabilitykit.common.intent.BasePCGetImageUrlIntent;
import com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntentIntent;
import com.obric.capabilitykit.common.intent.BasePCIntentGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCPersonalContextFetchIntent;
import com.obric.capabilitykit.common.intent.BasePCPersonalContextSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCProactiveEventsIntent;
import com.obric.capabilitykit.common.intent.BasePCSearchAppEntityIntent;
import com.obric.capabilitykit.common.intent.BasePhoneCallIntent;
import com.obric.capabilitykit.common.intent.BasePhoneDeleteIntent;
import com.obric.capabilitykit.common.intent.BasePhoneGetSimIntent;
import com.obric.capabilitykit.common.intent.BasePhoneOpenPageIntent;
import com.obric.capabilitykit.common.intent.BasePhoneProxyCallIntent;
import com.obric.capabilitykit.common.intent.BasePhoneSearchIntent;
import com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent;
import com.obric.capabilitykit.common.intent.BasePhotoAddPhotosToAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoAddToFavoriteIntent;
import com.obric.capabilitykit.common.intent.BasePhotoCreateAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoCropIntent;
import com.obric.capabilitykit.common.intent.BasePhotoDeleteAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoDeletePhotoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoGenerateVideoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoOpenAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoPaintPhotoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoRemovePhotosFromAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSearchAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSearchIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetBrightnessIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetClarityIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetContrastIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetExposureIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetFadeIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetFilterIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetRotationIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetSaturationIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetShadowIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetSharpnessIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetToneIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetWarmIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowPhotoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoUpdateAlbumIntent;
import com.obric.capabilitykit.common.intent.BaseRCComplexTaskContextIntent;
import com.obric.capabilitykit.common.intent.BaseRCDeviceStateIntent;
import com.obric.capabilitykit.common.intent.BaseRCSearchIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderOperateIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderShowRecordingIntent;
import com.obric.capabilitykit.common.intent.BaseSemanticSupplementIntent;
import com.obric.capabilitykit.common.intent.BaseShortVideoSearchIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAdjustBrightnessIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAdjustVolumeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAskUserIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.BaseSystemCheckPermissionsIntent;
import com.obric.capabilitykit.common.intent.BaseSystemDataSyncTriggerIntent;
import com.obric.capabilitykit.common.intent.BaseSystemDeviceStateIntent;
import com.obric.capabilitykit.common.intent.BaseSystemDownloadAppIntent;
import com.obric.capabilitykit.common.intent.BaseSystemFindPhoneIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetAppLatestVersionIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetLocationIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetWebUrlIntent;
import com.obric.capabilitykit.common.intent.BaseSystemHeartBeatIntent;
import com.obric.capabilitykit.common.intent.BaseSystemInAppSearchIntent;
import com.obric.capabilitykit.common.intent.BaseSystemJumpAppStoreIntent;
import com.obric.capabilitykit.common.intent.BaseSystemLocationRequestIntent;
import com.obric.capabilitykit.common.intent.BaseSystemMultiUserSelectIntent;
import com.obric.capabilitykit.common.intent.BaseSystemOpenAppIntent;
import com.obric.capabilitykit.common.intent.BaseSystemOpenPageIntent;
import com.obric.capabilitykit.common.intent.BaseSystemPowerLockControlIntent;
import com.obric.capabilitykit.common.intent.BaseSystemQAWithSearchIntent;
import com.obric.capabilitykit.common.intent.BaseSystemRebootIntent;
import com.obric.capabilitykit.common.intent.BaseSystemRequestPermissionsIntent;
import com.obric.capabilitykit.common.intent.BaseSystemScreenRecordIntent;
import com.obric.capabilitykit.common.intent.BaseSystemScreenshotIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSetBrightnessIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSetVolumeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSettingsAvailableIntent;
import com.obric.capabilitykit.common.intent.BaseSystemShellIntent;
import com.obric.capabilitykit.common.intent.BaseSystemShowEntitiesIntent;
import com.obric.capabilitykit.common.intent.BaseSystemShutdownIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSkillIntent;
import com.obric.capabilitykit.common.intent.BaseSystemStopActionIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSwitchModeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSwitchNotificationIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUpdatePermissionsIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserAuthorizeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserConfirmIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserRemindIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserSelectIntent;
import com.obric.capabilitykit.common.intent.BaseTravelSearchFlightIntent;
import com.obric.capabilitykit.common.intent.BaseTravelSearchHotelIntent;
import com.obric.capabilitykit.common.intent.BaseTravelSearchTrainIntent;
import com.obric.capabilitykit.common.intent.BaseWeatherSearchIntent;
import com.obric.capabilitykit.common.intent.BaseWeatherShowIntent;
import com.obric.common.upgrade.AppUpgradeImpl;
import com.obric.event.task.base.report.TaskDataApiImpl;
import com.obric.event.task.nlp.NaturalLanguageInstructionCreateApiImpl;
import com.obric.funcall_impl.IntentActionServiceImpl;
import com.obric.wakeup.impl.VoiceInteractionIDLStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class StaticServiceImplManager {
    private Map<String, Object> serviceImplCache;
    final Set<String> serviceImplNotExistSet;
    private Map<String, Set<Object>> serviceImplSetCache;
    final Set<String> serviceImplSetNotExistSet;

    private static class SingleInstanceHolder {
        private static final StaticServiceImplManager INSTANCE = null;

        private SingleInstanceHolder() {
        }

        static /* synthetic */ StaticServiceImplManager access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new StaticServiceImplManager();
        }
    }

    private Set getStaticServiceImplSetRealStub0(Class r3) {
        switch(r3.getName().hashCode()) {
            case -2083481319: goto L395;
            case -2082123139: goto L392;
            case -2029575578: goto L389;
            case -1954661635: goto L386;
            case -1941200558: goto L383;
            case -1937741378: goto L380;
            case -1849546285: goto L377;
            case -1844967145: goto L374;
            case -1838607762: goto L371;
            case -1831424951: goto L368;
            case -1775096167: goto L365;
            case -1758364323: goto L362;
            case -1750059076: goto L359;
            case -1722256923: goto L356;
            case -1639612991: goto L353;
            case -1457093386: goto L350;
            case -1430335244: goto L347;
            case -1420591951: goto L344;
            case -1412546756: goto L341;
            case -1329101953: goto L338;
            case -1324446904: goto L335;
            case -1284997761: goto L331;
            case -1245931124: goto L329;
            case -1238822745: goto L326;
            case -1237675067: goto L323;
            case -1223616584: goto L320;
            case -1189033446: goto L317;
            case -1171555865: goto L314;
            case -1125188041: goto L311;
            case -1120037584: goto L308;
            case -1108357093: goto L305;
            case -1097482074: goto L302;
            case -1077162907: goto L299;
            case -1074994092: goto L296;
            case -1009981876: goto L293;
            case -1005068052: goto L290;
            case -931165436: goto L287;
            case -929567000: goto L284;
            case -747830513: goto L281;
            case -705201322: goto L278;
            case -685521859: goto L275;
            case -678545819: goto L272;
            case -652729316: goto L269;
            case -651828405: goto L266;
            case -633505227: goto L263;
            case -569500645: goto L260;
            case -552767254: goto L257;
            case -531311326: goto L254;
            case -530150671: goto L251;
            case -520373310: goto L248;
            case -498457542: goto L245;
            case -471700129: goto L242;
            case -459692061: goto L239;
            case -405603167: goto L236;
            case -384350090: goto L233;
            case -344213275: goto L230;
            case -341908577: goto L227;
            case -337377259: goto L224;
            case -280646115: goto L221;
            case -221857235: goto L218;
            case -163125158: goto L215;
            case -151484532: goto L212;
            case -130723354: goto L209;
            case -92431714: goto L206;
            case 937577: goto L203;
            case 169417597: goto L200;
            case 180945420: goto L197;
            case 205710995: goto L194;
            case 214522593: goto L191;
            case 265537660: goto L188;
            case 336383059: goto L185;
            case 375207041: goto L182;
            case 452564393: goto L179;
            case 462091934: goto L176;
            case 479408845: goto L173;
            case 518538087: goto L170;
            case 532018905: goto L167;
            case 551578369: goto L164;
            case 553230459: goto L161;
            case 597765194: goto L158;
            case 603220747: goto L155;
            case 670088390: goto L152;
            case 681301384: goto L149;
            case 685576887: goto L146;
            case 738524666: goto L143;
            case 860927991: goto L140;
            case 891366147: goto L137;
            case 896450802: goto L134;
            case 1013370263: goto L131;
            case 1024882025: goto L128;
            case 1026716717: goto L125;
            case 1057067508: goto L122;
            case 1083716917: goto L119;
            case 1088750652: goto L116;
            case 1100326987: goto L113;
            case 1108176258: goto L110;
            case 1165239141: goto L107;
            case 1235693528: goto L104;
            case 1247446228: goto L101;
            case 1269285722: goto L98;
            case 1300772079: goto L95;
            case 1301517267: goto L92;
            case 1309928004: goto L89;
            case 1393267997: goto L86;
            case 1417712517: goto L83;
            case 1432154706: goto L80;
            case 1444833826: goto L77;
            case 1458961986: goto L74;
            case 1471909482: goto L71;
            case 1494356934: goto L68;
            case 1578945817: goto L65;
            case 1583588578: goto L62;
            case 1587736640: goto L59;
            case 1607317004: goto L56;
            case 1691063809: goto L53;
            case 1710798131: goto L50;
            case 1770846366: goto L47;
            case 1790175937: goto L44;
            case 1807849801: goto L41;
            case 1862250107: goto L38;
            case 1864436951: goto L35;
            case 1864830267: goto L32;
            case 1876636382: goto L29;
            case 1886984018: goto L26;
            case 2001907495: goto L23;
            case 2006409608: goto L20;
            case 2022976655: goto L17;
            case 2083022937: goto L14;
            case 2085582352: goto L11;
            case 2140226136: goto L6;
            default: goto L529;
        };
    L331:
        String r0 = "com.obric.autogui.common.api.platform.AOPlatformProviderInterface";
        if (r3.getName().equals("com.obric.autogui.common.api.platform.AOPlatformProviderInterface") == false) goto L507;
        HashSet r4 = new HashSet();
        Object r1 = new AOPlatformProvider();
    L334:
        r4.add(r1);
    L8:
        putStaticServiceImplSetCache(r0, r4);
        return r4;
    L507:
        return null;
    L335:
        r0 = "com.obric.aiagent.performance.IMemoryReportService";
        if (r3.getName().equals("com.obric.aiagent.performance.IMemoryReportService") == false) goto L508;
        r4 = new HashSet();
        r1 = new MemoryReportServiceImpl();
        goto L334
    L508:
        return null;
    L338:
        r0 = "com.obric.autogui.tools.api.IImageXApi";
        if (r3.getName().equals("com.obric.autogui.tools.api.IImageXApi") == false) goto L509;
        r4 = new HashSet();
        r1 = new ImageXApiImpl();
        goto L334
    L509:
        return null;
    L341:
        r0 = "com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi";
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi") == false) goto L510;
        r4 = new HashSet();
        r1 = new RegistrationManager();
        goto L334
    L510:
        return null;
    L344:
        r0 = "com.obric.agent.permission.IPermissionService";
        if (r3.getName().equals("com.obric.agent.permission.IPermissionService") == false) goto L511;
        r4 = new HashSet();
        r1 = new PermissionServiceImpl();
        goto L334
    L511:
        return null;
    L347:
        r0 = "com.obric.aiagent.skill.virt.api.IVirtService";
        if (r3.getName().equals("com.obric.aiagent.skill.virt.api.IVirtService") == false) goto L512;
        r4 = new HashSet();
        r1 = new Virt();
        goto L334
    L512:
        return null;
    L350:
        r0 = "com.obric.autogui.vdplayer.api.function.IFunctionController";
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.function.IFunctionController") == false) goto L513;
        r4 = new HashSet();
        r1 = new FunctionControllerImpl();
        goto L334
    L513:
        return null;
    L353:
        r0 = "com.obric.aiagent.interaction.api.IPlatformApi";
        if (r3.getName().equals("com.obric.aiagent.interaction.api.IPlatformApi") == false) goto L514;
        r4 = new HashSet();
        r1 = new PlatformApiImpl();
        goto L334
    L514:
        return null;
    L356:
        r0 = "com.obric.agent.complextask.IComplexTaskService";
        if (r3.getName().equals("com.obric.agent.complextask.IComplexTaskService") == false) goto L515;
        r4 = new HashSet();
        r1 = new ComplexTaskServiceImpl();
        goto L334
    L515:
        return null;
    L359:
        r0 = "com.obric.autoaction.app.launcherpage.api.IAutoTaskApi";
        if (r3.getName().equals("com.obric.autoaction.app.launcherpage.api.IAutoTaskApi") == false) goto L516;
        r4 = new HashSet();
        r1 = new AutoTaskImpl();
        goto L334
    L516:
        return null;
    L362:
        r0 = "com.obric.aiagent.account.IAccountService";
        if (r3.getName().equals("com.obric.aiagent.account.IAccountService") == false) goto L517;
        r4 = new HashSet();
        r1 = new AccountServiceImpl();
        goto L334
    L517:
        return null;
    L365:
        r0 = "com.obric.aiagent.product.api.IObricProduct";
        if (r3.getName().equals("com.obric.aiagent.product.api.IObricProduct") == false) goto L518;
        r4 = new HashSet();
        r1 = new ObricProductImpl();
        goto L334
    L518:
        return null;
    L368:
        r0 = "com.obric.autogui.api.IOAutoStateManager";
        if (r3.getName().equals("com.obric.autogui.api.IOAutoStateManager") == false) goto L519;
        r4 = new HashSet();
        r1 = new OmniTaskStateManagerImpl();
        goto L334
    L519:
        return null;
    L371:
        r0 = "com.obric.agent.IAgentService";
        if (r3.getName().equals("com.obric.agent.IAgentService") == false) goto L520;
        r4 = new HashSet();
        r1 = new AgentServiceImpl();
        goto L334
    L520:
        return null;
    L374:
        r0 = "com.obric.agent.IFlowIntentActionService";
        if (r3.getName().equals("com.obric.agent.IFlowIntentActionService") == false) goto L521;
        r4 = new HashSet();
        r1 = new FlowIntentActionServiceImpl();
        goto L334
    L521:
        return null;
    L377:
        r0 = "com.obric.autogui.common.api.cocreation.IOmniLabelingFeedbackUploader";
        if (r3.getName().equals("com.obric.autogui.common.api.cocreation.IOmniLabelingFeedbackUploader") == false) goto L522;
        r4 = new HashSet();
        r1 = new OmniLabelingFeedbackUploaderImpl();
        goto L334
    L522:
        return null;
    L380:
        r0 = "com.obric.autogui.database.service.EventTaskService";
        if (r3.getName().equals("com.obric.autogui.database.service.EventTaskService") == false) goto L523;
        r4 = new HashSet();
        r1 = new EventTaskServiceImpl();
        goto L334
    L523:
        return null;
    L383:
        r0 = "com.obric.aiagent.ipc.IAgentIpcManager";
        if (r3.getName().equals("com.obric.aiagent.ipc.IAgentIpcManager") == false) goto L524;
        r4 = new HashSet();
        r1 = new AgentIpcManagerImpl();
        goto L334
    L524:
        return null;
    L386:
        r0 = "com.obric.aiagent.privacy.IPrivacyService";
        if (r3.getName().equals("com.obric.aiagent.privacy.IPrivacyService") == false) goto L525;
        r4 = new HashSet();
        r1 = new PrivacyServiceImpl();
        goto L334
    L525:
        return null;
    L389:
        r0 = "com.obric.eventkit.task.api.IEventTaskRecordApi";
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskRecordApi") == false) goto L526;
        r4 = new HashSet();
        r1 = new EventTaskRecordApiImpl();
        goto L334
    L526:
        return null;
    L392:
        r0 = "com.obric.aiagent.platform.depend.IAppContext";
        if (r3.getName().equals("com.obric.aiagent.platform.depend.IAppContext") == false) goto L527;
        r4 = new HashSet();
        r1 = new PluginAppContextImpl();
        goto L334
    L527:
        return null;
    L395:
        r0 = "com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionSettingsService";
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionSettingsService") == false) goto L528;
        r4 = new HashSet();
        r1 = new AppFunctionSettingsServiceImpl();
        goto L334
    L528:
        return null;
    L529:
        return null;
    L6:
        if (r3.getName().equals("com.obric.autogui.common.api.space.cc.ICCSpaceSpawner") == false) goto L398;
        r4 = new HashSet();
        r4.add(new StandardCCSpaceSpawner());
        r0 = "com.obric.autogui.common.api.space.cc.ICCSpaceSpawner";
        goto L8
    L398:
        return null;
    L11:
        if (r3.getName().equals("com.obric.aiagent.product.platform.api.rom.IRomInfo") == false) goto L400;
        r4 = new HashSet();
        r4.add(new CommonRomInfoImpl());
        r0 = "com.obric.aiagent.product.platform.api.rom.IRomInfo";
        goto L8
    L400:
        return null;
    L14:
        if (r3.getName().equals("com.obric.agent.message.IAgentMessageExtProvider") == false) goto L401;
        r4 = new HashSet();
        r4.add(new AppEntityMessageExtProvider());
        r4.add(new DoraMessageExtProvider());
        r0 = "com.obric.agent.message.IAgentMessageExtProvider";
        goto L8
    L401:
        return null;
    L17:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.IAutoActionNetApi") == false) goto L402;
        r4 = new HashSet();
        r4.add(new TTNetNetworkApiImpl());
        r0 = "com.obric.autogui.tools.api.net.IAutoActionNetApi";
        goto L8
    L402:
        return null;
    L20:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ICloudConfig") == false) goto L403;
        r4 = new HashSet();
        r4.add(new StaticCloudConfigImpl());
        r0 = "com.obric.aiagent.platform.depend.ICloudConfig";
        goto L8
    L403:
        return null;
    L23:
        if (r3.getName().equals("com.obric.autogui.common.api.configs.IAutoActionConfigsApi") == false) goto L404;
        r4 = new HashSet();
        r4.add(new SettingsViaFlowApiImpl());
        r0 = "com.obric.autogui.common.api.configs.IAutoActionConfigsApi";
        goto L8
    L404:
        return null;
    L26:
        if (r3.getName().equals("com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi") == false) goto L405;
        r4 = new HashSet();
        r4.add(new AutoActionTasksImpl());
        r0 = "com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi";
        goto L8
    L405:
        return null;
    L29:
        if (r3.getName().equals("com.obric.autogui.common.api.assistant.IAssistCardResourceProvider") == false) goto L406;
        r4 = new HashSet();
        r4.add(new AssistCardResProviderImpl());
        r0 = "com.obric.autogui.common.api.assistant.IAssistCardResourceProvider";
        goto L8
    L406:
        return null;
    L32:
        if (r3.getName().equals("com.obric.autogui.common.api.app.IAutoActionHostResProvider") == false) goto L407;
        r4 = new HashSet();
        r4.add(new AutoActionHostResProviderImpl());
        r0 = "com.obric.autogui.common.api.app.IAutoActionHostResProvider";
        goto L8
    L407:
        return null;
    L35:
        if (r3.getName().equals("com.obric.event.task.nlp.spi.IEventTaskNlpDepend") == false) goto L408;
        r4 = new HashSet();
        r4.add(new EventTaskNlpDependImpl());
        r0 = "com.obric.event.task.nlp.spi.IEventTaskNlpDepend";
        goto L8
    L408:
        return null;
    L38:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionAgentEventListener") == false) goto L409;
        r4 = new HashSet();
        r4.add(new LegacyUIEventListener());
        r4.add(new RecordHistoryStepStateListener());
        r4.add(new KnowledgeAutoActionAgentEventListener());
        r4.add(new NewAddedTimerTaskRecordImpl());
        r4.add(new GUIEventListener());
        r4.add(new AIAgentEventListener());
        r4.add(new EndOfTaskOpenAppListener());
        r4.add(new AssistInputClarifyEndHandler());
        r4.add(new AssistInputAgentStateListener());
        r4.add(new AutoAgentEventToWidgetStateImpl());
        r4.add(new AgentStateProviderEventListener());
        r4.add(new OperatorBizTrackingListener());
        r4.add(new OperatingSpaceBizStateListeners());
        r4.add(new AgentExecSpecsDBListenerImpl());
        r4.add(new ObricSecurityListenerForAgent());
        r4.add(new AgentOperationStateListener());
        r4.add(new VirtualDisplayRecordSetBizStateListener());
        r4.add(new AgentEventDispatcher());
        r0 = "com.obric.autogui.common.api.agent.IAutoActionAgentEventListener";
        goto L8
    L409:
        return null;
    L41:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionSessionManager") == false) goto L410;
        r4 = new HashSet();
        r4.add(new SessionManagerImpl());
        r0 = "com.obric.autogui.common.api.agent.IAutoActionSessionManager";
        goto L8
    L410:
        return null;
    L44:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ILogDepend") == false) goto L411;
        r4 = new HashSet();
        r4.add(new ALogDependImpl());
        r0 = "com.obric.aiagent.platform.depend.ILogDepend";
        goto L8
    L411:
        return null;
    L47:
        if (r3.getName().equals("com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService") == false) goto L412;
        r4 = new HashSet();
        r4.add(new OmniClientToolTraceServiceImpl());
        r0 = "com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService";
        goto L8
    L412:
        return null;
    L50:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI") == false) goto L413;
        r4 = new HashSet();
        r4.add(new SkillManagerIDLSPIImpl());
        r0 = "com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI";
        goto L8
    L413:
        return null;
    L53:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker") == false) goto L414;
        r4 = new HashSet();
        r4.add(new AppFunctionInvoker());
        r0 = "com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker";
        goto L8
    L414:
        return null;
    L56:
        if (r3.getName().equals("com.obric.aiagent.trace.ITraceReport") == false) goto L415;
        r4 = new HashSet();
        r4.add(new TraceReportImpl());
        r0 = "com.obric.aiagent.trace.ITraceReport";
        goto L8
    L415:
        return null;
    L59:
        if (r3.getName().equals("com.obric.aiagent.skill.credentials.api.ISkillCredentialService") == false) goto L416;
        r4 = new HashSet();
        r4.add(new SafetyGuardSkillCredentialService());
        r0 = "com.obric.aiagent.skill.credentials.api.ISkillCredentialService";
        goto L8
    L416:
        return null;
    L62:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IAutoActionNotificationApi") == false) goto L417;
        r4 = new HashSet();
        r4.add(new AutoActionNotifApiImpl());
        r0 = "com.obric.autogui.common.api.presentation.IAutoActionNotificationApi";
        goto L8
    L417:
        return null;
    L65:
        if (r3.getName().equals("com.obric.aiagent.skill.virt.api.VirtReportSink") == false) goto L418;
        r4 = new HashSet();
        r4.add(new OVirtReporter());
        r0 = "com.obric.aiagent.skill.virt.api.VirtReportSink";
        goto L8
    L418:
        return null;
    L68:
        if (r3.getName().equals("com.obric.aiagent.privacy_sec.IPrivacy") == false) goto L419;
        r4 = new HashSet();
        r4.add(new PrivacyImpl());
        r0 = "com.obric.aiagent.privacy_sec.IPrivacy";
        goto L8
    L419:
        return null;
    L71:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.secure.ISecureTipsApi") == false) goto L420;
        r4 = new HashSet();
        r4.add(new AppSecureTipsApiImpl());
        r0 = "com.obric.autogui.vdplayer.api.secure.ISecureTipsApi";
        goto L8
    L420:
        return null;
    L74:
        if (r3.getName().equals("com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi") == false) goto L421;
        r4 = new HashSet();
        r4.add(new AutoActionVDimpl());
        r0 = "com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi";
        goto L8
    L421:
        return null;
    L77:
        if (r3.getName().equals("com.obric.aiagent.performance.IPerformanceMonitor") == false) goto L422;
        r4 = new HashSet();
        r4.add(new PerformanceMonitorImpl());
        r0 = "com.obric.aiagent.performance.IPerformanceMonitor";
        goto L8
    L422:
        return null;
    L80:
        if (r3.getName().equals("com.obric.funcall_api.IIntentActionService") == false) goto L423;
        r4 = new HashSet();
        r4.add(new IntentActionServiceImpl());
        r0 = "com.obric.funcall_api.IIntentActionService";
        goto L8
    L423:
        return null;
    L83:
        if (r3.getName().equals("com.obric.agent.omnimodel.IOmniModelService") == false) goto L424;
        r4 = new HashSet();
        r4.add(new OmniModelServiceImpl());
        r0 = "com.obric.agent.omnimodel.IOmniModelService";
        goto L8
    L424:
        return null;
    L86:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi") == false) goto L425;
        r4 = new HashSet();
        r4.add(new StandardModelRemoteAgentImpl());
        r0 = "com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi";
        goto L8
    L425:
        return null;
    L89:
        if (r3.getName().equals("com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService") == false) goto L426;
        r4 = new HashSet();
        r4.add(new SkillInstallAttributionServiceImpl());
        r0 = "com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService";
        goto L8
    L426:
        return null;
    L92:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener") == false) goto L427;
        r4 = new HashSet();
        r4.add(new AssistRemoteCardUpdateImpl());
        r4.add(new CallUserStateHandler());
        r4.add(new ClarifyStateHandler());
        r4.add(new FinishStateHandler());
        r4.add(new IslandDialogueModeHandler());
        r4.add(new SetTimerTaskHandler());
        r4.add(new TaskCreateStateHandler());
        r4.add(new TaskOperatingStateHandler());
        r4.add(new UserInterruptStateHandler());
        r4.add(new OAutoStateProviderUpdateImpl());
        r4.add(new WidgetStateToUIContext());
        r0 = "com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener";
        goto L8
    L427:
        return null;
    L95:
        if (r3.getName().equals("com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi") == false) goto L428;
        r4 = new HashSet();
        r4.add(new JobManagerImpl());
        r0 = "com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi";
        goto L8
    L428:
        return null;
    L98:
        if (r3.getName().equals("com.obric.autogui.session.state.holderfile.ISessionFinalizer") == false) goto L429;
        r4 = new HashSet();
        r4.add(new AssistCardFinalizer());
        r0 = "com.obric.autogui.session.state.holderfile.ISessionFinalizer";
        goto L8
    L429:
        return null;
    L101:
        if (r3.getName().equals("com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi") == false) goto L430;
        r4 = new HashSet();
        r4.add(new AutoActionAppFoundationImpl());
        r0 = "com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi";
        goto L8
    L430:
        return null;
    L104:
        if (r3.getName().equals("com.obric.aiagent.apm.IApm") == false) goto L431;
        r4 = new HashSet();
        r4.add(new ApmImpl());
        r0 = "com.obric.aiagent.apm.IApm";
        goto L8
    L431:
        return null;
    L107:
        if (r3.getName().equals("com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI") == false) goto L432;
        r4 = new HashSet();
        r4.add(new AppIntentIPCLifecycleImpl());
        r4.add(new IPCIDLChecker());
        r4.add(new PrivacyAgreeEvent());
        r4.add(new IPCLifeTrace());
        r0 = "com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI";
        goto L8
    L432:
        return null;
    L110:
        if (r3.getName().equals("com.obric.aiagent.applog.ICommonParams") == false) goto L433;
        r4 = new HashSet();
        r4.add(new CommonParamsImpl());
        r0 = "com.obric.aiagent.applog.ICommonParams";
        goto L8
    L433:
        return null;
    L113:
        if (r3.getName().equals("com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi") == false) goto L434;
        r4 = new HashSet();
        r4.add(new NaturalLanguageInstructionCreateApiImpl());
        r0 = "com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi";
        goto L8
    L434:
        return null;
    L116:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDLSPI") == false) goto L435;
        r4 = new HashSet();
        r4.add(new DMStateManagerIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDLSPI";
        goto L8
    L435:
        return null;
    L119:
        if (r3.getName().equals("com.obric.capabilitykit.common.intent.IntentFunction") == false) goto L436;
        r4 = new HashSet();
        r4.add(new BaseAppFuncExecuteIntent());
        r4.add(new BaseAudioControlPauseIntent());
        r4.add(new BaseAudioControlPlayFromScratchIntent());
        r4.add(new BaseAudioControlPlayIntent());
        r4.add(new BaseAudioControlPlayNextIntent());
        r4.add(new BaseAudioControlPlayPreviousIntent());
        r4.add(new BaseAudioControlSeekToIntent());
        r4.add(new BaseBrowserUseIntent());
        r4.add(new BaseCalculatorCalculateIntent());
        r4.add(new BaseCalendarShowScheduleIntent());
        r4.add(new BaseCameraRotateCameraIntent());
        r4.add(new BaseCameraSetAuxiliaryLineIntent());
        r4.add(new BaseCameraSetEVIntent());
        r4.add(new BaseCameraSetExposureTimeIntent());
        r4.add(new BaseCameraSetFilterIntent());
        r4.add(new BaseCameraSetFlashModeIntent());
        r4.add(new BaseCameraSetFocalIntent());
        r4.add(new BaseCameraSetFocusDistanceIntent());
        r4.add(new BaseCameraSetISOIntent());
        r4.add(new BaseCameraSetImageRatioIntent());
        r4.add(new BaseCameraSetMeteringModeIntent());
        r4.add(new BaseCameraSetSelfTimerIntent());
        r4.add(new BaseCameraSetTouchCaptureIntent());
        r4.add(new BaseCameraSetWBIntent());
        r4.add(new BaseCameraStartCaptureIntent());
        r4.add(new BaseCameraStartRecordingIntent());
        r4.add(new BaseCameraStopCaptureIntent());
        r4.add(new BaseCameraSwitchCameraModeIntent());
        r4.add(new BaseClockCreateAlarmIntent());
        r4.add(new BaseClockDeleteAlarmIntent());
        r4.add(new BaseClockDeleteCountdownIntent());
        r4.add(new BaseClockPauseCountdownIntent());
        r4.add(new BaseClockResumeCountdownIntent());
        r4.add(new BaseClockSearchAlarmIntent());
        r4.add(new BaseClockSearchCountdownIntent());
        r4.add(new BaseClockShowAlarmIntent());
        r4.add(new BaseClockShowCountdownIntent());
        r4.add(new BaseClockStartCountdownIntent());
        r4.add(new BaseClockTurnOffAlarmIntent());
        r4.add(new BaseClockTurnOnAlarmIntent());
        r4.add(new BaseClockUpdateAlarmIntent());
        r4.add(new BaseCommonViewEntitiesIntent());
        r4.add(new BaseContactsAddToBlocklistIntent());
        r4.add(new BaseContactsAddToFavoriteIntent());
        r4.add(new BaseContactsCreateIntent());
        r4.add(new BaseContactsDeleteIntent());
        r4.add(new BaseContactsSearchIntent());
        r4.add(new BaseContactsShowContactIntent());
        r4.add(new BaseContactsUpdateIntent());
        r4.add(new BaseDoubaoRealTimeScreenShareIntent());
        r4.add(new BaseDoubaoRealTimeVideoCallIntent());
        r4.add(new BaseDoubaoRealTimeVoiceCallIntent());
        r4.add(new BaseEventTaskCreateDraftIntent());
        r4.add(new BaseEventTaskGetTaskInfoIntent());
        r4.add(new BaseEventTaskSubmitTaskIntent());
        r4.add(new BaseEventTaskUpdateTaskIntent());
        r4.add(new BaseFilesShowFileIntent());
        r4.add(new BaseFinanceSearchStockIntent());
        r4.add(new BaseGUIActionIntent());
        r4.add(new BaseGUIINITIntent());
        r4.add(new BaseGUIReplyIntent());
        r4.add(new BaseGUIScreenshotIntent());
        r4.add(new BaseMapNaviRouteIntent());
        r4.add(new BaseMapSearchPOIIntent());
        r4.add(new BaseMapTakeTaxiIntent());
        r4.add(new BaseMemoryDeleteIntent());
        r4.add(new BaseMemoryOperateIntent());
        r4.add(new BaseMemoryOperateNewIntent());
        r4.add(new BaseMemoryProduceIntent());
        r4.add(new BaseMemorySaveDialogueMemoryIntent());
        r4.add(new BaseMemorySearchIntent());
        r4.add(new BaseMessagesDeleteIntent());
        r4.add(new BaseMessagesSearchIntent());
        r4.add(new BaseMessagesSendIntent());
        r4.add(new BaseMessagesShowMessageIntent());
        r4.add(new BaseNetEaseCloudMusicSearchIntent());
        r4.add(new BaseNotesCreateIntent());
        r4.add(new BaseNotesSearchIntent());
        r4.add(new BaseNotesShowNoteIntent());
        r4.add(new BaseNotesUpdateIntent());
        r4.add(new BaseOfficeBookMeetingIntent());
        r4.add(new BaseOfficeCheckLoginIntent());
        r4.add(new BaseOfficeJumpToLarkUrlIntent());
        r4.add(new BaseOfficeKnowledgeAIAuthIntent());
        r4.add(new BaseOfficeKnowledgeAIIntent());
        r4.add(new BaseOfficeLarkCLICheckLoginIntent());
        r4.add(new BaseOfficeLarkCLIEnsureAuthIntent());
        r4.add(new BaseOfficeSearchLarkContactInfoByAsrIntent());
        r4.add(new BaseOfficeSearchLarkContactInfoByNameIntent());
        r4.add(new BaseOfficeSearchMeetingIntent());
        r4.add(new BaseOfficeSendMessageIntent());
        r4.add(new BasePCAppFcEntitySearchIntent());
        r4.add(new BasePCCommonGlobalSearchIntent());
        r4.add(new BasePCDoubaoGlobalSearchIntent());
        r4.add(new BasePCEntityPoisonLabelIntent());
        r4.add(new BasePCGetImageUrlIntent());
        r4.add(new BasePCGlobalSearchIntent());
        r4.add(new BasePCGlobalSearchIntentIntent());
        r4.add(new BasePCIntentGlobalSearchIntent());
        r4.add(new BasePCPersonalContextFetchIntent());
        r4.add(new BasePCPersonalContextSearchIntent());
        r4.add(new BasePCProactiveEventsIntent());
        r4.add(new BasePCSearchAppEntityIntent());
        r4.add(new BasePhoneCallIntent());
        r4.add(new BasePhoneDeleteIntent());
        r4.add(new BasePhoneGetSimIntent());
        r4.add(new BasePhoneOpenPageIntent());
        r4.add(new BasePhoneProxyCallIntent());
        r4.add(new BasePhoneSearchIntent());
        r4.add(new BasePhoneShowCallHistoryIntent());
        r4.add(new BasePhotoAddPhotosToAlbumIntent());
        r4.add(new BasePhotoAddToFavoriteIntent());
        r4.add(new BasePhotoCreateAlbumIntent());
        r4.add(new BasePhotoCropIntent());
        r4.add(new BasePhotoDeleteAlbumIntent());
        r4.add(new BasePhotoDeletePhotoIntent());
        r4.add(new BasePhotoGenerateVideoIntent());
        r4.add(new BasePhotoOpenAlbumIntent());
        r4.add(new BasePhotoPaintPhotoIntent());
        r4.add(new BasePhotoRemovePhotosFromAlbumIntent());
        r4.add(new BasePhotoSearchAlbumIntent());
        r4.add(new BasePhotoSearchIntent());
        r4.add(new BasePhotoSetBrightnessIntent());
        r4.add(new BasePhotoSetClarityIntent());
        r4.add(new BasePhotoSetContrastIntent());
        r4.add(new BasePhotoSetExposureIntent());
        r4.add(new BasePhotoSetFadeIntent());
        r4.add(new BasePhotoSetFilterIntent());
        r4.add(new BasePhotoSetRotationIntent());
        r4.add(new BasePhotoSetSaturationIntent());
        r4.add(new BasePhotoSetShadowIntent());
        r4.add(new BasePhotoSetSharpnessIntent());
        r4.add(new BasePhotoSetToneIntent());
        r4.add(new BasePhotoSetWarmIntent());
        r4.add(new BasePhotoShowAlbumIntent());
        r4.add(new BasePhotoShowPhotoIntent());
        r4.add(new BasePhotoUpdateAlbumIntent());
        r4.add(new BaseRCComplexTaskContextIntent());
        r4.add(new BaseRCDeviceStateIntent());
        r4.add(new BaseRCSearchIntent());
        r4.add(new BaseRecorderDeleteIntent());
        r4.add(new BaseRecorderOperateIntent());
        r4.add(new BaseRecorderShowRecordingIntent());
        r4.add(new BaseSemanticSupplementIntent());
        r4.add(new BaseShortVideoSearchIntent());
        r4.add(new BaseSystemAdjustBrightnessIntent());
        r4.add(new BaseSystemAdjustVolumeIntent());
        r4.add(new BaseSystemAskUserIntent());
        r4.add(new BaseSystemAutoActionIntent());
        r4.add(new BaseSystemCheckPermissionsIntent());
        r4.add(new BaseSystemDataSyncTriggerIntent());
        r4.add(new BaseSystemDeviceStateIntent());
        r4.add(new BaseSystemDownloadAppIntent());
        r4.add(new BaseSystemFindPhoneIntent());
        r4.add(new BaseSystemGetAppLatestVersionIntent());
        r4.add(new BaseSystemGetLocationIntent());
        r4.add(new BaseSystemGetWebUrlIntent());
        r4.add(new BaseSystemHeartBeatIntent());
        r4.add(new BaseSystemInAppSearchIntent());
        r4.add(new BaseSystemJumpAppStoreIntent());
        r4.add(new BaseSystemLocationRequestIntent());
        r4.add(new BaseSystemMultiUserSelectIntent());
        r4.add(new BaseSystemOpenAppIntent());
        r4.add(new BaseSystemOpenPageIntent());
        r4.add(new BaseSystemPowerLockControlIntent());
        r4.add(new BaseSystemQAWithSearchIntent());
        r4.add(new BaseSystemRebootIntent());
        r4.add(new BaseSystemRequestPermissionsIntent());
        r4.add(new BaseSystemScreenRecordIntent());
        r4.add(new BaseSystemScreenshotIntent());
        r4.add(new BaseSystemSetBrightnessIntent());
        r4.add(new BaseSystemSetVolumeIntent());
        r4.add(new BaseSystemSettingsAvailableIntent());
        r4.add(new BaseSystemShellIntent());
        r4.add(new BaseSystemShowEntitiesIntent());
        r4.add(new BaseSystemShutdownIntent());
        r4.add(new BaseSystemSkillIntent());
        r4.add(new BaseSystemStopActionIntent());
        r4.add(new BaseSystemSwitchModeIntent());
        r4.add(new BaseSystemSwitchNotificationIntent());
        r4.add(new BaseSystemUpdatePermissionsIntent());
        r4.add(new BaseSystemUserAuthorizeIntent());
        r4.add(new BaseSystemUserConfirmIntent());
        r4.add(new BaseSystemUserRemindIntent());
        r4.add(new BaseSystemUserSelectIntent());
        r4.add(new BaseTravelSearchFlightIntent());
        r4.add(new BaseTravelSearchHotelIntent());
        r4.add(new BaseTravelSearchTrainIntent());
        r4.add(new BaseWeatherSearchIntent());
        r4.add(new BaseWeatherShowIntent());
        r0 = "com.obric.capabilitykit.common.intent.IntentFunction";
        goto L8
    L436:
        return null;
    L122:
        if (r3.getName().equals("com.obric.autogui.agents.scripted.api.IJSScriptService") == false) goto L437;
        r4 = new HashSet();
        r4.add(new JSScriptServiceImpl());
        r0 = "com.obric.autogui.agents.scripted.api.IJSScriptService";
        goto L8
    L437:
        return null;
    L125:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi") == false) goto L438;
        r4 = new HashSet();
        r4.add(new IntentInfoManagerService());
        r0 = "com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi";
        goto L8
    L438:
        return null;
    L128:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.api.IAssistInputStateManager") == false) goto L439;
        r4 = new HashSet();
        r4.add(new AssistInputStateManagerImpl());
        r0 = "com.obric.autogui.common.api.presentation.api.IAssistInputStateManager";
        goto L8
    L439:
        return null;
    L131:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDLSPI") == false) goto L440;
        r4 = new HashSet();
        r4.add(new VoiceInteractionIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDLSPI";
        goto L8
    L440:
        return null;
    L134:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ISysLogDepend") == false) goto L441;
        r4 = new HashSet();
        r4.add(new SysLogDependImpl());
        r0 = "com.obric.aiagent.platform.depend.ISysLogDepend";
        goto L8
    L441:
        return null;
    L137:
        if (r3.getName().equals("com.obric.agent.trace.IIntentMetricsService") == false) goto L442;
        r4 = new HashSet();
        r4.add(new IntentMetricsServiceImpl());
        r0 = "com.obric.agent.trace.IIntentMetricsService";
        goto L8
    L442:
        return null;
    L140:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentIDLSPI") == false) goto L443;
        r4 = new HashSet();
        r4.add(new AssistantIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentIDLSPI";
        goto L8
    L443:
        return null;
    L143:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentSettingsIDLSPI") == false) goto L444;
        r4 = new HashSet();
        r4.add(new AgentSettingsIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentSettingsIDLSPI";
        goto L8
    L444:
        return null;
    L146:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi") == false) goto L445;
        r4 = new HashSet();
        r4.add(new ActionMatcherService());
        r0 = "com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi";
        goto L8
    L445:
        return null;
    L149:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager") == false) goto L446;
        r4 = new HashSet();
        r4.add(new AgentSessionManagerImpl());
        r0 = "com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager";
        goto L8
    L446:
        return null;
    L152:
        if (r3.getName().equals("com.obric.aiagent.security.IAiAgentSecurityService") == false) goto L447;
        r4 = new HashSet();
        r4.add(new AiAgentSecurityServiceImpl());
        r0 = "com.obric.aiagent.security.IAiAgentSecurityService";
        goto L8
    L447:
        return null;
    L155:
        if (r3.getName().equals("com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder") == false) goto L448;
        r4 = new HashSet();
        r4.add(new OmniLabelingUserStopRecorderImpl());
        r0 = "com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder";
        goto L8
    L448:
        return null;
    L158:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ISecureLogDepend") == false) goto L449;
        r4 = new HashSet();
        r4.add(new ALogSecureDependImpl());
        r0 = "com.obric.aiagent.platform.depend.ISecureLogDepend";
        goto L8
    L449:
        return null;
    L161:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentTaskAppIDLSPI") == false) goto L450;
        r4 = new HashSet();
        r4.add(new TaskAppIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentTaskAppIDLSPI";
        goto L8
    L450:
        return null;
    L164:
        if (r3.getName().equals("com.obric.autogui.common.api.platform.screen.capture.IDonationApi") == false) goto L451;
        r4 = new HashSet();
        r4.add(new DonationImpl());
        r0 = "com.obric.autogui.common.api.platform.screen.capture.IDonationApi";
        goto L8
    L451:
        return null;
    L167:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IPlatformApiIDLSPI") == false) goto L452;
        r4 = new HashSet();
        r4.add(new PlatformApiIDLSPIImpl());
        r0 = "com.obric.aiagent.assistant.idl.IPlatformApiIDLSPI";
        goto L8
    L452:
        return null;
    L170:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionAgentApi") == false) goto L453;
        r4 = new HashSet();
        r4.add(new AutoActionAgentImpl());
        r0 = "com.obric.autogui.common.api.agent.IAutoActionAgentApi";
        goto L8
    L453:
        return null;
    L173:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentNetworkIDLSPI") == false) goto L454;
        r4 = new HashSet();
        r4.add(new AgentNetworkIDLSPIImpl());
        r0 = "com.obric.aiagent.assistant.idl.IAgentNetworkIDLSPI";
        goto L8
    L454:
        return null;
    L176:
        if (r3.getName().equals("com.obric.aiagent.ipc.idl.IFileIDLSPI") == false) goto L455;
        r4 = new HashSet();
        r4.add(new FileIDLStubImpl());
        r0 = "com.obric.aiagent.ipc.idl.IFileIDLSPI";
        goto L8
    L455:
        return null;
    L179:
        if (r3.getName().equals("com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi") == false) goto L456;
        r4 = new HashSet();
        r4.add(new UriFileAccessMiddleman());
        r0 = "com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi";
        goto L8
    L456:
        return null;
    L182:
        if (r3.getName().equals("com.obric.agent.trace.IIntentTraceService") == false) goto L457;
        r4 = new HashSet();
        r4.add(new IntentTraceServiceImpl());
        r0 = "com.obric.agent.trace.IIntentTraceService";
        goto L8
    L457:
        return null;
    L185:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IAutoActionPresentationApi") == false) goto L458;
        r4 = new HashSet();
        r4.add(new AutoActionPresentationApiImpl());
        r0 = "com.obric.autogui.common.api.presentation.IAutoActionPresentationApi";
        goto L8
    L458:
        return null;
    L188:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI") == false) goto L459;
        r4 = new HashSet();
        r4.add(new AppIntentIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI";
        goto L8
    L459:
        return null;
    L191:
        if (r3.getName().equals("com.obric.autoaction.app.launcherpage.api.ITaskDataApi") == false) goto L460;
        r4 = new HashSet();
        r4.add(new TaskDataApiImpl());
        r0 = "com.obric.autoaction.app.launcherpage.api.ITaskDataApi";
        goto L8
    L460:
        return null;
    L194:
        if (r3.getName().equals("com.obric.agent.trace.IOmniReportService") == false) goto L461;
        r4 = new HashSet();
        r4.add(new OmniReportServiceImpl());
        r0 = "com.obric.agent.trace.IOmniReportService";
        goto L8
    L461:
        return null;
    L197:
        if (r3.getName().equals("com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener") == false) goto L462;
        r4 = new HashSet();
        r4.add(new LarkCliOVirtLifecycleListener());
        r0 = "com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener";
        goto L8
    L462:
        return null;
    L200:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.IAutoActionNetStatusApi") == false) goto L463;
        r4 = new HashSet();
        r4.add(new ObricNetStatusImpl());
        r0 = "com.obric.autogui.tools.api.net.IAutoActionNetStatusApi";
        goto L8
    L463:
        return null;
    L203:
        if (r3.getName().equals("com.obric.autogui.common.api.userreport.IAutoActionUserReportApi") == false) goto L464;
        r4 = new HashSet();
        r4.add(new OAppUserReportImpl());
        r0 = "com.obric.autogui.common.api.userreport.IAutoActionUserReportApi";
        goto L8
    L464:
        return null;
    L206:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi") == false) goto L465;
        r4 = new HashSet();
        r4.add(new WsChannelApiImpl());
        r0 = "com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi";
        goto L8
    L465:
        return null;
    L209:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentMessageIDLSPI") == false) goto L466;
        r4 = new HashSet();
        r4.add(new MessageIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentMessageIDLSPI";
        goto L8
    L466:
        return null;
    L212:
        if (r3.getName().equals("com.obric.agent.IEntityManager") == false) goto L467;
        r4 = new HashSet();
        r4.add(new EntityManagerImpl());
        r0 = "com.obric.agent.IEntityManager";
        goto L8
    L467:
        return null;
    L215:
        if (r3.getName().equals("com.obric.eventkit.task.api.ILegacyTimerApi") == false) goto L468;
        r4 = new HashSet();
        r4.add(new LegacyTimerApiImpl());
        r0 = "com.obric.eventkit.task.api.ILegacyTimerApi";
        goto L8
    L468:
        return null;
    L218:
        if (r3.getName().equals("com.obric.assistant.dm.api.IDialogManagement") == false) goto L469;
        r4 = new HashSet();
        r4.add(new DialogManagement());
        r0 = "com.obric.assistant.dm.api.IDialogManagement";
        goto L8
    L469:
        return null;
    L221:
        if (r3.getName().equals("com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink") == false) goto L470;
        r4 = new HashSet();
        r4.add(new OmniLabelingHostBridgeDataSink());
        r0 = "com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink";
        goto L8
    L470:
        return null;
    L224:
        if (r3.getName().equals("com.obric.aiagent.skill.manager.api.ISkillManagerService") == false) goto L471;
        r4 = new HashSet();
        r4.add(new SkillManager());
        r0 = "com.obric.aiagent.skill.manager.api.ISkillManagerService";
        goto L8
    L471:
        return null;
    L227:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener") == false) goto L472;
        r4 = new HashSet();
        r4.add(new NotifCallUserListernerImpl());
        r4.add(new UIAgentFunctionListener());
        r4.add(new AssistInputFunctionEventHandler());
        r0 = "com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener";
        goto L8
    L472:
        return null;
    L230:
        if (r3.getName().equals("com.obric.aiagent.skill.manager.api.ISkillSettingsService") == false) goto L473;
        r4 = new HashSet();
        r4.add(new SkillSettingsServiceImpl());
        r0 = "com.obric.aiagent.skill.manager.api.ISkillSettingsService";
        goto L8
    L473:
        return null;
    L233:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.ITimerTaskListener") == false) goto L474;
        r4 = new HashSet();
        r4.add(new AssistCardTimerTaskUpdateImpl());
        r0 = "com.obric.autogui.common.api.presentation.ITimerTaskListener";
        goto L8
    L474:
        return null;
    L236:
        if (r3.getName().equals("com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig") == false) goto L475;
        r4 = new HashSet();
        r4.add(new FeatureSettingsImpl());
        r0 = "com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig";
        goto L8
    L475:
        return null;
    L239:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskListenerApi") == false) goto L476;
        r4 = new HashSet();
        r4.add(new EventTaskListenerApiImpl());
        r0 = "com.obric.eventkit.task.api.IEventTaskListenerApi";
        goto L8
    L476:
        return null;
    L242:
        if (r3.getName().equals("com.obric.aiagent.ttnet.ITTNetFileTransfer") == false) goto L477;
        r4 = new HashSet();
        r4.add(new TTNetFileTransferImpl());
        r0 = "com.obric.aiagent.ttnet.ITTNetFileTransfer";
        goto L8
    L477:
        return null;
    L245:
        if (r3.getName().equals("com.obric.agent.IAgentExecutor") == false) goto L478;
        r4 = new HashSet();
        r4.add(new AgentExecutionEngineImpl());
        r0 = "com.obric.agent.IAgentExecutor";
        goto L8
    L478:
        return null;
    L248:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ITraceDepend") == false) goto L479;
        r4 = new HashSet();
        r4.add(new TraceDependImpl());
        r0 = "com.obric.aiagent.platform.depend.ITraceDepend";
        goto L8
    L479:
        return null;
    L251:
        if (r3.getName().equals("com.obric.autogui.api.IAutoActionAppListApi") == false) goto L480;
        r4 = new HashSet();
        r4.add(new AutoActionAppListApiImpl());
        r0 = "com.obric.autogui.api.IAutoActionAppListApi";
        goto L8
    L480:
        return null;
    L254:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi") == false) goto L481;
        r4 = new HashSet();
        r4.add(new VirtualDisplayApiImpl());
        r0 = "com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi";
        goto L8
    L481:
        return null;
    L257:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.push.IAutoActionPushApi") == false) goto L482;
        r4 = new HashSet();
        r4.add(new PushApiImpl());
        r0 = "com.obric.autogui.tools.api.net.push.IAutoActionPushApi";
        goto L8
    L482:
        return null;
    L260:
        if (r3.getName().equals("com.obric.agent.message.IMessageCollectService") == false) goto L483;
        r4 = new HashSet();
        r4.add(new MessageCollectServiceImpl());
        r0 = "com.obric.agent.message.IMessageCollectService";
        goto L8
    L483:
        return null;
    L263:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.api.IAssistInputHost") == false) goto L484;
        r4 = new HashSet();
        r4.add(new AssistInputImpl());
        r0 = "com.obric.autogui.common.api.presentation.api.IAssistInputHost";
        goto L8
    L484:
        return null;
    L266:
        if (r3.getName().equals("com.obric.eventkit.ITaskManagerApi") == false) goto L485;
        r4 = new HashSet();
        r4.add(new TaskManagerImpl());
        r0 = "com.obric.eventkit.ITaskManagerApi";
        goto L8
    L485:
        return null;
    L269:
        if (r3.getName().equals("com.obric.autogui.tools.api.IAutoActionAppUpgradeApi") == false) goto L486;
        r4 = new HashSet();
        r4.add(new AppUpgradeImpl());
        r0 = "com.obric.autogui.tools.api.IAutoActionAppUpgradeApi";
        goto L8
    L486:
        return null;
    L272:
        if (r3.getName().equals("com.obric.agent.autoaction.IAutoActionService") == false) goto L487;
        r4 = new HashSet();
        r4.add(new AutoActionServiceImpl());
        r0 = "com.obric.agent.autoaction.IAutoActionService";
        goto L8
    L487:
        return null;
    L275:
        if (r3.getName().equals("com.obric.autoaction.app.launcherpage.main.IMainTab") == false) goto L488;
        r4 = new HashSet();
        r4.add(new AutomationTab());
        r4.add(new DiscoveryTab());
        r4.add(new ShortCutTab());
        r0 = "com.obric.autoaction.app.launcherpage.main.IMainTab";
        goto L8
    L488:
        return null;
    L278:
        if (r3.getName().equals("com.obric.agent.auth.IAgentAuthService") == false) goto L489;
        r4 = new HashSet();
        r4.add(new AgentAuthServiceImpl());
        r0 = "com.obric.agent.auth.IAgentAuthService";
        goto L8
    L489:
        return null;
    L281:
        if (r3.getName().equals("com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask") == false) goto L490;
        r4 = new HashSet();
        r4.add(new CleanHeifScreenshotCacheTask());
        r4.add(new InitAIKernelTask());
        r4.add(new InitAppListListeneningTask());
        r4.add(new InitAuthStateTask());
        r4.add(new InitCardProviderTask());
        r4.add(new InitFrameWorkUnMuteWhiteListInjectTask());
        r4.add(new InitIslandTask());
        r4.add(new InitOmniUploadImageTask());
        r4.add(new InitSettingTask());
        r4.add(new InitThermalListeningTask());
        r4.add(new InitTrackingTask());
        r4.add(new InitUserReportTask());
        r4.add(new RemoveDanglingTask());
        r4.add(new ScriptFoundationReadyTask());
        r4.add(new FlowMessageListenerRegister());
        r0 = "com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask";
        goto L8
    L490:
        return null;
    L284:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IDonationTaskStateApi") == false) goto L491;
        r4 = new HashSet();
        r4.add(new DonationTaskStateImpl());
        r0 = "com.obric.autogui.common.api.presentation.IDonationTaskStateApi";
        goto L8
    L491:
        return null;
    L287:
        if (r3.getName().equals("com.obric.agent.IAppIntentFeedback") == false) goto L492;
        r4 = new HashSet();
        r4.add(new AppIntentFeedbackImpl());
        r0 = "com.obric.agent.IAppIntentFeedback";
        goto L8
    L492:
        return null;
    L290:
        if (r3.getName().equals("com.obric.aiagent.skill.ovirt.api.IOVirtService") == false) goto L493;
        r4 = new HashSet();
        r4.add(new OVirt());
        r0 = "com.obric.aiagent.skill.ovirt.api.IOVirtService";
        goto L8
    L493:
        return null;
    L293:
        if (r3.getName().equals("com.obric.aiagent.executionengine.scheduler.api.IEventManagerApi") == false) goto L494;
        r4 = new HashSet();
        r4.add(new EventManagerImpl());
        r0 = "com.obric.aiagent.executionengine.scheduler.api.IEventManagerApi";
        goto L8
    L494:
        return null;
    L296:
        if (r3.getName().equals("com.obric.aiagent.applog.IAppLog") == false) goto L495;
        r4 = new HashSet();
        r4.add(new AppLogImpl());
        r0 = "com.obric.aiagent.applog.IAppLog";
        goto L8
    L495:
        return null;
    L299:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskExecutionApi") == false) goto L496;
        r4 = new HashSet();
        r4.add(new EventTaskExecutionApiImpl());
        r0 = "com.obric.eventkit.task.api.IEventTaskExecutionApi";
        goto L8
    L496:
        return null;
    L302:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.feedback.IFeedbackApi") == false) goto L497;
        r4 = new HashSet();
        r4.add(new FeedbackApiImpl());
        r0 = "com.obric.autogui.vdplayer.api.feedback.IFeedbackApi";
        goto L8
    L497:
        return null;
    L305:
        if (r3.getName().equals("com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager") == false) goto L498;
        r4 = new HashSet();
        r4.add(new DialogStateManagerImpl());
        r0 = "com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager";
        goto L8
    L498:
        return null;
    L308:
        if (r3.getName().equals("com.obric.agent.im.IMessageObserverRegistry") == false) goto L499;
        r4 = new HashSet();
        r4.add(new MessageObserverRegistryImpl());
        r0 = "com.obric.agent.im.IMessageObserverRegistry";
        goto L8
    L499:
        return null;
    L311:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskApi") == false) goto L500;
        r4 = new HashSet();
        r4.add(new EventTaskApiImpl());
        r0 = "com.obric.eventkit.task.api.IEventTaskApi";
        goto L8
    L500:
        return null;
    L314:
        if (r3.getName().equals("com.obric.autogui.common.api.logging.IAutoActionLoggingApi") == false) goto L501;
        r4 = new HashSet();
        r4.add(new OAutoAIAgentLogging());
        r0 = "com.obric.autogui.common.api.logging.IAutoActionLoggingApi";
        goto L8
    L501:
        return null;
    L317:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.fws.IPlatformTools") == false) goto L502;
        r4 = new HashSet();
        r4.add(new PlatformToolsImpl());
        r0 = "com.obric.autogui.vdplayer.api.fws.IPlatformTools";
        goto L8
    L502:
        return null;
    L320:
        if (r3.getName().equals("com.obric.aiagent.ttnet.ITTNet") == false) goto L503;
        r4 = new HashSet();
        r4.add(new TTNetImpl());
        r0 = "com.obric.aiagent.ttnet.ITTNet";
        goto L8
    L503:
        return null;
    L323:
        if (r3.getName().equals("com.obric.autogui.common.api.model.IAutoActionLocalModelProvider") == false) goto L504;
        r4 = new HashSet();
        r4.add(new TFLiteModelProvider());
        r0 = "com.obric.autogui.common.api.model.IAutoActionLocalModelProvider";
        goto L8
    L504:
        return null;
    L326:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentPrivacyIDLSPI") == false) goto L505;
        r4 = new HashSet();
        r4.add(new PrivacyIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IAgentPrivacyIDLSPI";
        goto L8
    L505:
        return null;
    L329:
        if (r3.getName().equals("com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener") == false) goto L506;
        r4 = new HashSet();
        r4.add(new VDEventsListenerImpl());
        r0 = "com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener";
        goto L8
    L506:
        return null;
    }

    public StaticServiceImplManager() {
        this.serviceImplCache = new ConcurrentHashMap();
        this.serviceImplNotExistSet = Collections.synchronizedSet(new HashSet());
        this.serviceImplSetCache = new ConcurrentHashMap();
        this.serviceImplSetNotExistSet = Collections.synchronizedSet(new HashSet());
    }

    public static StaticServiceImplManager getInstance() {
        return SingleInstanceHolder.access$000();
    }

    public <T> T getStaticServiceImpl(Class<T> r4) {
        String r0 = r4.getName();
        T r1 = (T) this.serviceImplCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.serviceImplNotExistSet.contains(r0) == false) goto L7;
        return r1;
    L7:
        return (T) getStaticServiceImplReal(r4);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> r5) {
        String r0 = r5.getName();
        Set<T> r1 = (Set) ZeusTransformUtils.preCheckCast(this.serviceImplSetCache.get(r0), Set.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.serviceImplSetNotExistSet.contains(r0) == false) goto L7;
        return r1;
    L7:
        return getStaticServiceImplSetReal(r5);
    }

    private <T> T getStaticServiceImplReal(Class<T> r3) {
        switch(r3.getName().hashCode()) {
            case -2083481319: goto L522;
            case -2082123139: goto L518;
            case -2029575578: goto L514;
            case -1954661635: goto L510;
            case -1941200558: goto L506;
            case -1937741378: goto L502;
            case -1849546285: goto L498;
            case -1844967145: goto L494;
            case -1838607762: goto L490;
            case -1831424951: goto L486;
            case -1775096167: goto L482;
            case -1758364323: goto L478;
            case -1750059076: goto L474;
            case -1722256923: goto L470;
            case -1639612991: goto L466;
            case -1457093386: goto L462;
            case -1430335244: goto L458;
            case -1420591951: goto L454;
            case -1412546756: goto L450;
            case -1329101953: goto L446;
            case -1324446904: goto L442;
            case -1284997761: goto L438;
            case -1245931124: goto L434;
            case -1238822745: goto L430;
            case -1237675067: goto L426;
            case -1223616584: goto L422;
            case -1189033446: goto L418;
            case -1171555865: goto L414;
            case -1125188041: goto L410;
            case -1120037584: goto L406;
            case -1108357093: goto L402;
            case -1097482074: goto L398;
            case -1077162907: goto L394;
            case -1074994092: goto L390;
            case -1009981876: goto L386;
            case -1005068052: goto L382;
            case -931165436: goto L378;
            case -929567000: goto L374;
            case -747830513: goto L370;
            case -705201322: goto L366;
            case -685521859: goto L362;
            case -678545819: goto L358;
            case -652729316: goto L354;
            case -651828405: goto L350;
            case -633505227: goto L346;
            case -569500645: goto L342;
            case -552767254: goto L338;
            case -531311326: goto L334;
            case -530150671: goto L330;
            case -520373310: goto L326;
            case -498457542: goto L322;
            case -471700129: goto L318;
            case -459692061: goto L314;
            case -405603167: goto L310;
            case -384350090: goto L306;
            case -344213275: goto L302;
            case -341908577: goto L298;
            case -337377259: goto L294;
            case -280646115: goto L290;
            case -221857235: goto L286;
            case -163125158: goto L282;
            case -151484532: goto L278;
            case -130723354: goto L274;
            case -92431714: goto L270;
            case 937577: goto L266;
            case 169417597: goto L262;
            case 180945420: goto L258;
            case 205710995: goto L254;
            case 214522593: goto L250;
            case 265537660: goto L246;
            case 336383059: goto L242;
            case 375207041: goto L238;
            case 452564393: goto L234;
            case 462091934: goto L230;
            case 479408845: goto L226;
            case 518538087: goto L222;
            case 532018905: goto L218;
            case 551578369: goto L214;
            case 553230459: goto L210;
            case 597765194: goto L206;
            case 603220747: goto L202;
            case 670088390: goto L198;
            case 681301384: goto L194;
            case 685576887: goto L190;
            case 738524666: goto L186;
            case 860927991: goto L182;
            case 891366147: goto L178;
            case 896450802: goto L174;
            case 1013370263: goto L170;
            case 1024882025: goto L166;
            case 1026716717: goto L162;
            case 1057067508: goto L158;
            case 1083716917: goto L154;
            case 1088750652: goto L150;
            case 1100326987: goto L146;
            case 1108176258: goto L142;
            case 1165239141: goto L138;
            case 1235693528: goto L134;
            case 1247446228: goto L130;
            case 1269285722: goto L126;
            case 1300772079: goto L122;
            case 1301517267: goto L118;
            case 1309928004: goto L114;
            case 1393267997: goto L110;
            case 1417712517: goto L106;
            case 1432154706: goto L102;
            case 1444833826: goto L98;
            case 1458961986: goto L94;
            case 1471909482: goto L90;
            case 1494356934: goto L86;
            case 1578945817: goto L82;
            case 1583588578: goto L78;
            case 1587736640: goto L74;
            case 1607317004: goto L70;
            case 1691063809: goto L66;
            case 1710798131: goto L62;
            case 1770846366: goto L58;
            case 1790175937: goto L54;
            case 1807849801: goto L50;
            case 1862250107: goto L46;
            case 1864436951: goto L42;
            case 1864830267: goto L38;
            case 1876636382: goto L34;
            case 1886984018: goto L30;
            case 2001907495: goto L26;
            case 2006409608: goto L22;
            case 2022976655: goto L18;
            case 2083022937: goto L14;
            case 2085582352: goto L10;
            case 2140226136: goto L6;
            default: goto L525;
        };
    L525:
        this.serviceImplNotExistSet.add(r3.getName());
        return null;
    L6:
        if (r3.getName().equals("com.obric.autogui.common.api.space.cc.ICCSpaceSpawner") == false) goto L525;
        T r4 = (T) new StandardCCSpaceSpawner();
        putStaticServiceImplCache("com.obric.autogui.common.api.space.cc.ICCSpaceSpawner", r4);
        return r4;
    L10:
        if (r3.getName().equals("com.obric.aiagent.product.platform.api.rom.IRomInfo") == false) goto L525;
        T r5 = (T) new CommonRomInfoImpl();
        putStaticServiceImplCache("com.obric.aiagent.product.platform.api.rom.IRomInfo", r5);
        return r5;
    L14:
        if (r3.getName().equals("com.obric.agent.message.IAgentMessageExtProvider") == false) goto L525;
        T r6 = (T) new DoraMessageExtProvider();
        putStaticServiceImplCache("com.obric.agent.message.IAgentMessageExtProvider", r6);
        return r6;
    L18:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.IAutoActionNetApi") == false) goto L525;
        T r7 = (T) new TTNetNetworkApiImpl();
        putStaticServiceImplCache("com.obric.autogui.tools.api.net.IAutoActionNetApi", r7);
        return r7;
    L22:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ICloudConfig") == false) goto L525;
        T r8 = (T) new StaticCloudConfigImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.depend.ICloudConfig", r8);
        return r8;
    L26:
        if (r3.getName().equals("com.obric.autogui.common.api.configs.IAutoActionConfigsApi") == false) goto L525;
        T r9 = (T) new SettingsViaFlowApiImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.configs.IAutoActionConfigsApi", r9);
        return r9;
    L30:
        if (r3.getName().equals("com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi") == false) goto L525;
        T r10 = (T) new AutoActionTasksImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi", r10);
        return r10;
    L34:
        if (r3.getName().equals("com.obric.autogui.common.api.assistant.IAssistCardResourceProvider") == false) goto L525;
        T r11 = (T) new AssistCardResProviderImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.assistant.IAssistCardResourceProvider", r11);
        return r11;
    L38:
        if (r3.getName().equals("com.obric.autogui.common.api.app.IAutoActionHostResProvider") == false) goto L525;
        T r12 = (T) new AutoActionHostResProviderImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.app.IAutoActionHostResProvider", r12);
        return r12;
    L42:
        if (r3.getName().equals("com.obric.event.task.nlp.spi.IEventTaskNlpDepend") == false) goto L525;
        T r13 = (T) new EventTaskNlpDependImpl();
        putStaticServiceImplCache("com.obric.event.task.nlp.spi.IEventTaskNlpDepend", r13);
        return r13;
    L46:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionAgentEventListener") == false) goto L525;
        T r14 = (T) new ObricSecurityListenerForAgent();
        putStaticServiceImplCache("com.obric.autogui.common.api.agent.IAutoActionAgentEventListener", r14);
        return r14;
    L50:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionSessionManager") == false) goto L525;
        T r15 = (T) new SessionManagerImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.agent.IAutoActionSessionManager", r15);
        return r15;
    L54:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ILogDepend") == false) goto L525;
        T r16 = (T) new ALogDependImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.depend.ILogDepend", r16);
        return r16;
    L58:
        if (r3.getName().equals("com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService") == false) goto L525;
        T r17 = (T) new OmniClientToolTraceServiceImpl();
        putStaticServiceImplCache("com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService", r17);
        return r17;
    L62:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI") == false) goto L525;
        T r18 = (T) new SkillManagerIDLSPIImpl();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI", r18);
        return r18;
    L66:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker") == false) goto L525;
        T r19 = (T) new AppFunctionInvoker();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker", r19);
        return r19;
    L70:
        if (r3.getName().equals("com.obric.aiagent.trace.ITraceReport") == false) goto L525;
        T r20 = (T) new TraceReportImpl();
        putStaticServiceImplCache("com.obric.aiagent.trace.ITraceReport", r20);
        return r20;
    L74:
        if (r3.getName().equals("com.obric.aiagent.skill.credentials.api.ISkillCredentialService") == false) goto L525;
        T r21 = (T) new SafetyGuardSkillCredentialService();
        putStaticServiceImplCache("com.obric.aiagent.skill.credentials.api.ISkillCredentialService", r21);
        return r21;
    L78:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IAutoActionNotificationApi") == false) goto L525;
        T r22 = (T) new AutoActionNotifApiImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.presentation.IAutoActionNotificationApi", r22);
        return r22;
    L82:
        if (r3.getName().equals("com.obric.aiagent.skill.virt.api.VirtReportSink") == false) goto L525;
        T r23 = (T) new OVirtReporter();
        putStaticServiceImplCache("com.obric.aiagent.skill.virt.api.VirtReportSink", r23);
        return r23;
    L86:
        if (r3.getName().equals("com.obric.aiagent.privacy_sec.IPrivacy") == false) goto L525;
        T r24 = (T) new PrivacyImpl();
        putStaticServiceImplCache("com.obric.aiagent.privacy_sec.IPrivacy", r24);
        return r24;
    L90:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.secure.ISecureTipsApi") == false) goto L525;
        T r25 = (T) new AppSecureTipsApiImpl();
        putStaticServiceImplCache("com.obric.autogui.vdplayer.api.secure.ISecureTipsApi", r25);
        return r25;
    L94:
        if (r3.getName().equals("com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi") == false) goto L525;
        T r26 = (T) new AutoActionVDimpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi", r26);
        return r26;
    L98:
        if (r3.getName().equals("com.obric.aiagent.performance.IPerformanceMonitor") == false) goto L525;
        T r27 = (T) new PerformanceMonitorImpl();
        putStaticServiceImplCache("com.obric.aiagent.performance.IPerformanceMonitor", r27);
        return r27;
    L102:
        if (r3.getName().equals("com.obric.funcall_api.IIntentActionService") == false) goto L525;
        T r28 = (T) new IntentActionServiceImpl();
        putStaticServiceImplCache("com.obric.funcall_api.IIntentActionService", r28);
        return r28;
    L106:
        if (r3.getName().equals("com.obric.agent.omnimodel.IOmniModelService") == false) goto L525;
        T r29 = (T) new OmniModelServiceImpl();
        putStaticServiceImplCache("com.obric.agent.omnimodel.IOmniModelService", r29);
        return r29;
    L110:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi") == false) goto L525;
        T r30 = (T) new StandardModelRemoteAgentImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi", r30);
        return r30;
    L114:
        if (r3.getName().equals("com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService") == false) goto L525;
        T r31 = (T) new SkillInstallAttributionServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService", r31);
        return r31;
    L118:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener") == false) goto L525;
        return (T) new IslandDialogueModeHandler();
    L122:
        if (r3.getName().equals("com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi") == false) goto L525;
        T r32 = (T) new JobManagerImpl();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi", r32);
        return r32;
    L126:
        if (r3.getName().equals("com.obric.autogui.session.state.holderfile.ISessionFinalizer") == false) goto L525;
        T r33 = (T) new AssistCardFinalizer();
        putStaticServiceImplCache("com.obric.autogui.session.state.holderfile.ISessionFinalizer", r33);
        return r33;
    L130:
        if (r3.getName().equals("com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi") == false) goto L525;
        T r34 = (T) new AutoActionAppFoundationImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi", r34);
        return r34;
    L134:
        if (r3.getName().equals("com.obric.aiagent.apm.IApm") == false) goto L525;
        T r35 = (T) new ApmImpl();
        putStaticServiceImplCache("com.obric.aiagent.apm.IApm", r35);
        return r35;
    L138:
        if (r3.getName().equals("com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI") == false) goto L525;
        T r36 = (T) new PrivacyAgreeEvent();
        putStaticServiceImplCache("com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI", r36);
        return r36;
    L142:
        if (r3.getName().equals("com.obric.aiagent.applog.ICommonParams") == false) goto L525;
        T r37 = (T) new CommonParamsImpl();
        putStaticServiceImplCache("com.obric.aiagent.applog.ICommonParams", r37);
        return r37;
    L146:
        if (r3.getName().equals("com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi") == false) goto L525;
        T r38 = (T) new NaturalLanguageInstructionCreateApiImpl();
        putStaticServiceImplCache("com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi", r38);
        return r38;
    L150:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDLSPI") == false) goto L525;
        T r39 = (T) new DMStateManagerIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDLSPI", r39);
        return r39;
    L154:
        if (r3.getName().equals("com.obric.capabilitykit.common.intent.IntentFunction") == false) goto L525;
        T r40 = (T) new BaseAppFuncExecuteIntent();
        putStaticServiceImplCache("com.obric.capabilitykit.common.intent.IntentFunction", r40);
        return r40;
    L158:
        if (r3.getName().equals("com.obric.autogui.agents.scripted.api.IJSScriptService") == false) goto L525;
        T r41 = (T) new JSScriptServiceImpl();
        putStaticServiceImplCache("com.obric.autogui.agents.scripted.api.IJSScriptService", r41);
        return r41;
    L162:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi") == false) goto L525;
        T r42 = (T) new IntentInfoManagerService();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi", r42);
        return r42;
    L166:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.api.IAssistInputStateManager") == false) goto L525;
        T r43 = (T) new AssistInputStateManagerImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.presentation.api.IAssistInputStateManager", r43);
        return r43;
    L170:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDLSPI") == false) goto L525;
        T r44 = (T) new VoiceInteractionIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDLSPI", r44);
        return r44;
    L174:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ISysLogDepend") == false) goto L525;
        T r45 = (T) new SysLogDependImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.depend.ISysLogDepend", r45);
        return r45;
    L178:
        if (r3.getName().equals("com.obric.agent.trace.IIntentMetricsService") == false) goto L525;
        T r46 = (T) new IntentMetricsServiceImpl();
        putStaticServiceImplCache("com.obric.agent.trace.IIntentMetricsService", r46);
        return r46;
    L182:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentIDLSPI") == false) goto L525;
        T r47 = (T) new AssistantIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentIDLSPI", r47);
        return r47;
    L186:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentSettingsIDLSPI") == false) goto L525;
        T r48 = (T) new AgentSettingsIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentSettingsIDLSPI", r48);
        return r48;
    L190:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi") == false) goto L525;
        T r49 = (T) new ActionMatcherService();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi", r49);
        return r49;
    L194:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager") == false) goto L525;
        T r50 = (T) new AgentSessionManagerImpl();
        putStaticServiceImplCache("com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager", r50);
        return r50;
    L198:
        if (r3.getName().equals("com.obric.aiagent.security.IAiAgentSecurityService") == false) goto L525;
        T r51 = (T) new AiAgentSecurityServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.security.IAiAgentSecurityService", r51);
        return r51;
    L202:
        if (r3.getName().equals("com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder") == false) goto L525;
        T r52 = (T) new OmniLabelingUserStopRecorderImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder", r52);
        return r52;
    L206:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ISecureLogDepend") == false) goto L525;
        T r53 = (T) new ALogSecureDependImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.depend.ISecureLogDepend", r53);
        return r53;
    L210:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentTaskAppIDLSPI") == false) goto L525;
        T r54 = (T) new TaskAppIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentTaskAppIDLSPI", r54);
        return r54;
    L214:
        if (r3.getName().equals("com.obric.autogui.common.api.platform.screen.capture.IDonationApi") == false) goto L525;
        T r55 = (T) new DonationImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.platform.screen.capture.IDonationApi", r55);
        return r55;
    L218:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IPlatformApiIDLSPI") == false) goto L525;
        T r56 = (T) new PlatformApiIDLSPIImpl();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IPlatformApiIDLSPI", r56);
        return r56;
    L222:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionAgentApi") == false) goto L525;
        T r57 = (T) new AutoActionAgentImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.agent.IAutoActionAgentApi", r57);
        return r57;
    L226:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentNetworkIDLSPI") == false) goto L525;
        T r58 = (T) new AgentNetworkIDLSPIImpl();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentNetworkIDLSPI", r58);
        return r58;
    L230:
        if (r3.getName().equals("com.obric.aiagent.ipc.idl.IFileIDLSPI") == false) goto L525;
        T r59 = (T) new FileIDLStubImpl();
        putStaticServiceImplCache("com.obric.aiagent.ipc.idl.IFileIDLSPI", r59);
        return r59;
    L234:
        if (r3.getName().equals("com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi") == false) goto L525;
        T r60 = (T) new UriFileAccessMiddleman();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi", r60);
        return r60;
    L238:
        if (r3.getName().equals("com.obric.agent.trace.IIntentTraceService") == false) goto L525;
        T r61 = (T) new IntentTraceServiceImpl();
        putStaticServiceImplCache("com.obric.agent.trace.IIntentTraceService", r61);
        return r61;
    L242:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IAutoActionPresentationApi") == false) goto L525;
        T r62 = (T) new AutoActionPresentationApiImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.presentation.IAutoActionPresentationApi", r62);
        return r62;
    L246:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI") == false) goto L525;
        T r63 = (T) new AppIntentIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI", r63);
        return r63;
    L250:
        if (r3.getName().equals("com.obric.autoaction.app.launcherpage.api.ITaskDataApi") == false) goto L525;
        T r64 = (T) new TaskDataApiImpl();
        putStaticServiceImplCache("com.obric.autoaction.app.launcherpage.api.ITaskDataApi", r64);
        return r64;
    L254:
        if (r3.getName().equals("com.obric.agent.trace.IOmniReportService") == false) goto L525;
        T r65 = (T) new OmniReportServiceImpl();
        putStaticServiceImplCache("com.obric.agent.trace.IOmniReportService", r65);
        return r65;
    L258:
        if (r3.getName().equals("com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener") == false) goto L525;
        T r66 = (T) new LarkCliOVirtLifecycleListener();
        putStaticServiceImplCache("com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener", r66);
        return r66;
    L262:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.IAutoActionNetStatusApi") == false) goto L525;
        T r67 = (T) new ObricNetStatusImpl();
        putStaticServiceImplCache("com.obric.autogui.tools.api.net.IAutoActionNetStatusApi", r67);
        return r67;
    L266:
        if (r3.getName().equals("com.obric.autogui.common.api.userreport.IAutoActionUserReportApi") == false) goto L525;
        T r68 = (T) new OAppUserReportImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.userreport.IAutoActionUserReportApi", r68);
        return r68;
    L270:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi") == false) goto L525;
        T r69 = (T) new WsChannelApiImpl();
        putStaticServiceImplCache("com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi", r69);
        return r69;
    L274:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentMessageIDLSPI") == false) goto L525;
        T r70 = (T) new MessageIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentMessageIDLSPI", r70);
        return r70;
    L278:
        if (r3.getName().equals("com.obric.agent.IEntityManager") == false) goto L525;
        T r71 = (T) new EntityManagerImpl();
        putStaticServiceImplCache("com.obric.agent.IEntityManager", r71);
        return r71;
    L282:
        if (r3.getName().equals("com.obric.eventkit.task.api.ILegacyTimerApi") == false) goto L525;
        T r72 = (T) new LegacyTimerApiImpl();
        putStaticServiceImplCache("com.obric.eventkit.task.api.ILegacyTimerApi", r72);
        return r72;
    L286:
        if (r3.getName().equals("com.obric.assistant.dm.api.IDialogManagement") == false) goto L525;
        T r73 = (T) new DialogManagement();
        putStaticServiceImplCache("com.obric.assistant.dm.api.IDialogManagement", r73);
        return r73;
    L290:
        if (r3.getName().equals("com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink") == false) goto L525;
        T r74 = (T) new OmniLabelingHostBridgeDataSink();
        putStaticServiceImplCache("com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink", r74);
        return r74;
    L294:
        if (r3.getName().equals("com.obric.aiagent.skill.manager.api.ISkillManagerService") == false) goto L525;
        T r75 = (T) new SkillManager();
        putStaticServiceImplCache("com.obric.aiagent.skill.manager.api.ISkillManagerService", r75);
        return r75;
    L298:
        if (r3.getName().equals("com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener") == false) goto L525;
        T r76 = (T) new AssistInputFunctionEventHandler();
        putStaticServiceImplCache("com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener", r76);
        return r76;
    L302:
        if (r3.getName().equals("com.obric.aiagent.skill.manager.api.ISkillSettingsService") == false) goto L525;
        T r77 = (T) new SkillSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.skill.manager.api.ISkillSettingsService", r77);
        return r77;
    L306:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.ITimerTaskListener") == false) goto L525;
        T r78 = (T) new AssistCardTimerTaskUpdateImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.presentation.ITimerTaskListener", r78);
        return r78;
    L310:
        if (r3.getName().equals("com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig") == false) goto L525;
        T r79 = (T) new FeatureSettingsImpl();
        putStaticServiceImplCache("com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig", r79);
        return r79;
    L314:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskListenerApi") == false) goto L525;
        T r80 = (T) new EventTaskListenerApiImpl();
        putStaticServiceImplCache("com.obric.eventkit.task.api.IEventTaskListenerApi", r80);
        return r80;
    L318:
        if (r3.getName().equals("com.obric.aiagent.ttnet.ITTNetFileTransfer") == false) goto L525;
        T r81 = (T) new TTNetFileTransferImpl();
        putStaticServiceImplCache("com.obric.aiagent.ttnet.ITTNetFileTransfer", r81);
        return r81;
    L322:
        if (r3.getName().equals("com.obric.agent.IAgentExecutor") == false) goto L525;
        T r82 = (T) new AgentExecutionEngineImpl();
        putStaticServiceImplCache("com.obric.agent.IAgentExecutor", r82);
        return r82;
    L326:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.ITraceDepend") == false) goto L525;
        T r83 = (T) new TraceDependImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.depend.ITraceDepend", r83);
        return r83;
    L330:
        if (r3.getName().equals("com.obric.autogui.api.IAutoActionAppListApi") == false) goto L525;
        T r84 = (T) new AutoActionAppListApiImpl();
        putStaticServiceImplCache("com.obric.autogui.api.IAutoActionAppListApi", r84);
        return r84;
    L334:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi") == false) goto L525;
        T r85 = (T) new VirtualDisplayApiImpl();
        putStaticServiceImplCache("com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi", r85);
        return r85;
    L338:
        if (r3.getName().equals("com.obric.autogui.tools.api.net.push.IAutoActionPushApi") == false) goto L525;
        T r86 = (T) new PushApiImpl();
        putStaticServiceImplCache("com.obric.autogui.tools.api.net.push.IAutoActionPushApi", r86);
        return r86;
    L342:
        if (r3.getName().equals("com.obric.agent.message.IMessageCollectService") == false) goto L525;
        T r87 = (T) new MessageCollectServiceImpl();
        putStaticServiceImplCache("com.obric.agent.message.IMessageCollectService", r87);
        return r87;
    L346:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.api.IAssistInputHost") == false) goto L525;
        T r88 = (T) new AssistInputImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.presentation.api.IAssistInputHost", r88);
        return r88;
    L350:
        if (r3.getName().equals("com.obric.eventkit.ITaskManagerApi") == false) goto L525;
        T r89 = (T) new TaskManagerImpl();
        putStaticServiceImplCache("com.obric.eventkit.ITaskManagerApi", r89);
        return r89;
    L354:
        if (r3.getName().equals("com.obric.autogui.tools.api.IAutoActionAppUpgradeApi") == false) goto L525;
        T r90 = (T) new AppUpgradeImpl();
        putStaticServiceImplCache("com.obric.autogui.tools.api.IAutoActionAppUpgradeApi", r90);
        return r90;
    L358:
        if (r3.getName().equals("com.obric.agent.autoaction.IAutoActionService") == false) goto L525;
        T r91 = (T) new AutoActionServiceImpl();
        putStaticServiceImplCache("com.obric.agent.autoaction.IAutoActionService", r91);
        return r91;
    L362:
        if (r3.getName().equals("com.obric.autoaction.app.launcherpage.main.IMainTab") == false) goto L525;
        T r92 = (T) new AutomationTab();
        putStaticServiceImplCache("com.obric.autoaction.app.launcherpage.main.IMainTab", r92);
        return r92;
    L366:
        if (r3.getName().equals("com.obric.agent.auth.IAgentAuthService") == false) goto L525;
        T r93 = (T) new AgentAuthServiceImpl();
        putStaticServiceImplCache("com.obric.agent.auth.IAgentAuthService", r93);
        return r93;
    L370:
        if (r3.getName().equals("com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask") == false) goto L525;
        T r94 = (T) new CleanHeifScreenshotCacheTask();
        putStaticServiceImplCache("com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask", r94);
        return r94;
    L374:
        if (r3.getName().equals("com.obric.autogui.common.api.presentation.IDonationTaskStateApi") == false) goto L525;
        T r95 = (T) new DonationTaskStateImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.presentation.IDonationTaskStateApi", r95);
        return r95;
    L378:
        if (r3.getName().equals("com.obric.agent.IAppIntentFeedback") == false) goto L525;
        T r96 = (T) new AppIntentFeedbackImpl();
        putStaticServiceImplCache("com.obric.agent.IAppIntentFeedback", r96);
        return r96;
    L382:
        if (r3.getName().equals("com.obric.aiagent.skill.ovirt.api.IOVirtService") == false) goto L525;
        T r97 = (T) new OVirt();
        putStaticServiceImplCache("com.obric.aiagent.skill.ovirt.api.IOVirtService", r97);
        return r97;
    L386:
        if (r3.getName().equals("com.obric.aiagent.executionengine.scheduler.api.IEventManagerApi") == false) goto L525;
        T r98 = (T) new EventManagerImpl();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.scheduler.api.IEventManagerApi", r98);
        return r98;
    L390:
        if (r3.getName().equals("com.obric.aiagent.applog.IAppLog") == false) goto L525;
        T r99 = (T) new AppLogImpl();
        putStaticServiceImplCache("com.obric.aiagent.applog.IAppLog", r99);
        return r99;
    L394:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskExecutionApi") == false) goto L525;
        T r100 = (T) new EventTaskExecutionApiImpl();
        putStaticServiceImplCache("com.obric.eventkit.task.api.IEventTaskExecutionApi", r100);
        return r100;
    L398:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.feedback.IFeedbackApi") == false) goto L525;
        T r101 = (T) new FeedbackApiImpl();
        putStaticServiceImplCache("com.obric.autogui.vdplayer.api.feedback.IFeedbackApi", r101);
        return r101;
    L402:
        if (r3.getName().equals("com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager") == false) goto L525;
        T r102 = (T) new DialogStateManagerImpl();
        putStaticServiceImplCache("com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager", r102);
        return r102;
    L406:
        if (r3.getName().equals("com.obric.agent.im.IMessageObserverRegistry") == false) goto L525;
        T r103 = (T) new MessageObserverRegistryImpl();
        putStaticServiceImplCache("com.obric.agent.im.IMessageObserverRegistry", r103);
        return r103;
    L410:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskApi") == false) goto L525;
        T r104 = (T) new EventTaskApiImpl();
        putStaticServiceImplCache("com.obric.eventkit.task.api.IEventTaskApi", r104);
        return r104;
    L414:
        if (r3.getName().equals("com.obric.autogui.common.api.logging.IAutoActionLoggingApi") == false) goto L525;
        T r105 = (T) new OAutoAIAgentLogging();
        putStaticServiceImplCache("com.obric.autogui.common.api.logging.IAutoActionLoggingApi", r105);
        return r105;
    L418:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.fws.IPlatformTools") == false) goto L525;
        T r106 = (T) new PlatformToolsImpl();
        putStaticServiceImplCache("com.obric.autogui.vdplayer.api.fws.IPlatformTools", r106);
        return r106;
    L422:
        if (r3.getName().equals("com.obric.aiagent.ttnet.ITTNet") == false) goto L525;
        T r107 = (T) new TTNetImpl();
        putStaticServiceImplCache("com.obric.aiagent.ttnet.ITTNet", r107);
        return r107;
    L426:
        if (r3.getName().equals("com.obric.autogui.common.api.model.IAutoActionLocalModelProvider") == false) goto L525;
        T r108 = (T) new TFLiteModelProvider();
        putStaticServiceImplCache("com.obric.autogui.common.api.model.IAutoActionLocalModelProvider", r108);
        return r108;
    L430:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IAgentPrivacyIDLSPI") == false) goto L525;
        T r109 = (T) new PrivacyIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IAgentPrivacyIDLSPI", r109);
        return r109;
    L434:
        if (r3.getName().equals("com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener") == false) goto L525;
        T r110 = (T) new VDEventsListenerImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener", r110);
        return r110;
    L438:
        if (r3.getName().equals("com.obric.autogui.common.api.platform.AOPlatformProviderInterface") == false) goto L525;
        T r111 = (T) new AOPlatformProvider();
        putStaticServiceImplCache("com.obric.autogui.common.api.platform.AOPlatformProviderInterface", r111);
        return r111;
    L442:
        if (r3.getName().equals("com.obric.aiagent.performance.IMemoryReportService") == false) goto L525;
        T r112 = (T) new MemoryReportServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.performance.IMemoryReportService", r112);
        return r112;
    L446:
        if (r3.getName().equals("com.obric.autogui.tools.api.IImageXApi") == false) goto L525;
        T r113 = (T) new ImageXApiImpl();
        putStaticServiceImplCache("com.obric.autogui.tools.api.IImageXApi", r113);
        return r113;
    L450:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi") == false) goto L525;
        T r114 = (T) new RegistrationManager();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi", r114);
        return r114;
    L454:
        if (r3.getName().equals("com.obric.agent.permission.IPermissionService") == false) goto L525;
        T r115 = (T) new PermissionServiceImpl();
        putStaticServiceImplCache("com.obric.agent.permission.IPermissionService", r115);
        return r115;
    L458:
        if (r3.getName().equals("com.obric.aiagent.skill.virt.api.IVirtService") == false) goto L525;
        T r116 = (T) new Virt();
        putStaticServiceImplCache("com.obric.aiagent.skill.virt.api.IVirtService", r116);
        return r116;
    L462:
        if (r3.getName().equals("com.obric.autogui.vdplayer.api.function.IFunctionController") == false) goto L525;
        T r117 = (T) new FunctionControllerImpl();
        putStaticServiceImplCache("com.obric.autogui.vdplayer.api.function.IFunctionController", r117);
        return r117;
    L466:
        if (r3.getName().equals("com.obric.aiagent.interaction.api.IPlatformApi") == false) goto L525;
        T r118 = (T) new PlatformApiImpl();
        putStaticServiceImplCache("com.obric.aiagent.interaction.api.IPlatformApi", r118);
        return r118;
    L470:
        if (r3.getName().equals("com.obric.agent.complextask.IComplexTaskService") == false) goto L525;
        T r119 = (T) new ComplexTaskServiceImpl();
        putStaticServiceImplCache("com.obric.agent.complextask.IComplexTaskService", r119);
        return r119;
    L474:
        if (r3.getName().equals("com.obric.autoaction.app.launcherpage.api.IAutoTaskApi") == false) goto L525;
        T r120 = (T) new AutoTaskImpl();
        putStaticServiceImplCache("com.obric.autoaction.app.launcherpage.api.IAutoTaskApi", r120);
        return r120;
    L478:
        if (r3.getName().equals("com.obric.aiagent.account.IAccountService") == false) goto L525;
        T r121 = (T) new AccountServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.account.IAccountService", r121);
        return r121;
    L482:
        if (r3.getName().equals("com.obric.aiagent.product.api.IObricProduct") == false) goto L525;
        T r122 = (T) new ObricProductImpl();
        putStaticServiceImplCache("com.obric.aiagent.product.api.IObricProduct", r122);
        return r122;
    L486:
        if (r3.getName().equals("com.obric.autogui.api.IOAutoStateManager") == false) goto L525;
        T r123 = (T) new OmniTaskStateManagerImpl();
        putStaticServiceImplCache("com.obric.autogui.api.IOAutoStateManager", r123);
        return r123;
    L490:
        if (r3.getName().equals("com.obric.agent.IAgentService") == false) goto L525;
        T r124 = (T) new AgentServiceImpl();
        putStaticServiceImplCache("com.obric.agent.IAgentService", r124);
        return r124;
    L494:
        if (r3.getName().equals("com.obric.agent.IFlowIntentActionService") == false) goto L525;
        T r125 = (T) new FlowIntentActionServiceImpl();
        putStaticServiceImplCache("com.obric.agent.IFlowIntentActionService", r125);
        return r125;
    L498:
        if (r3.getName().equals("com.obric.autogui.common.api.cocreation.IOmniLabelingFeedbackUploader") == false) goto L525;
        T r126 = (T) new OmniLabelingFeedbackUploaderImpl();
        putStaticServiceImplCache("com.obric.autogui.common.api.cocreation.IOmniLabelingFeedbackUploader", r126);
        return r126;
    L502:
        if (r3.getName().equals("com.obric.autogui.database.service.EventTaskService") == false) goto L525;
        T r127 = (T) new EventTaskServiceImpl();
        putStaticServiceImplCache("com.obric.autogui.database.service.EventTaskService", r127);
        return r127;
    L506:
        if (r3.getName().equals("com.obric.aiagent.ipc.IAgentIpcManager") == false) goto L525;
        T r128 = (T) new AgentIpcManagerImpl();
        putStaticServiceImplCache("com.obric.aiagent.ipc.IAgentIpcManager", r128);
        return r128;
    L510:
        if (r3.getName().equals("com.obric.aiagent.privacy.IPrivacyService") == false) goto L525;
        T r129 = (T) new PrivacyServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.privacy.IPrivacyService", r129);
        return r129;
    L514:
        if (r3.getName().equals("com.obric.eventkit.task.api.IEventTaskRecordApi") == false) goto L525;
        T r130 = (T) new EventTaskRecordApiImpl();
        putStaticServiceImplCache("com.obric.eventkit.task.api.IEventTaskRecordApi", r130);
        return r130;
    L518:
        if (r3.getName().equals("com.obric.aiagent.platform.depend.IAppContext") == false) goto L525;
        T r131 = (T) new PluginAppContextImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.depend.IAppContext", r131);
        return r131;
    L522:
        if (r3.getName().equals("com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionSettingsService") == false) goto L525;
        T r132 = (T) new AppFunctionSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionSettingsService", r132);
        return r132;
    }

    private void putStaticServiceImplCache(String r1, Object r2) {
        this.serviceImplCache.put(r1, r2);
    }

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> r2) {
        Set<T> r0 = getStaticServiceImplSetRealStub0(r2);
        if (r0 != null) goto L6;
        this.serviceImplSetNotExistSet.add(r2.getName());
        return null;
    L6:
        return r0;
    }

    private void putStaticServiceImplSetCache(String r3, Set<Object> r4) {
        Set<Object> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        this.serviceImplSetCache.put(r3, r5);
    }
}
