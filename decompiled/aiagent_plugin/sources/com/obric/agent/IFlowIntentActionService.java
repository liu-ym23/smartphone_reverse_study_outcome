package com.obric.agent;

import com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import java.util.List;

/* JADX INFO: compiled from: IFlowIntentActionService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IFlowIntentActionService {
    void callPhone(String r1, ContactEntity r2, String r3, String r4);

    void deleteEntities(AppEntity[] r1, IEntityDeleteCallbackIDL r2);

    int pauseMusic();

    int playMusic(String r1, MusicEntity[] r2, MusicEntity r3);

    void registerMusicStateListener(IMusicStateListenerIDL r1);

    void retryLastShowEntity();

    void sendSms(String r1, ContactEntity r2, String r3, String r4);

    void showAlarm(AlarmEntity r1);

    void showAlbum(AlbumEntity r1);

    void showAuditoryRecording(AuditoryRecordingEntity r1);

    void showCallHistory(CallHistoryEntity r1);

    void showContact(ContactEntity r1);

    void showCountdown(CountdownEntity r1);

    void showFile(FileEntity r1);

    void showMemory(MemoryEntity r1);

    void showMessage(MessageEntity r1);

    void showMusicPage();

    void showNote(NoteEntity r1);

    void showPhoto(PhotoEntity[] r1, int r2);

    void showProactiveMemory(ProactiveMemoryEntity r1);

    void showRecording(RecordingEntity r1);

    void showSchedule(ScheduleEntity r1);

    void showWeather(String r1, String r2);

    void turnOnOffAlarm(AlarmEntity r1, boolean r2, String r3);

    void unregisterMusicStateListener(IMusicStateListenerIDL r1);

    void viewEntities(int r1, List<? extends AppEntity> r2, String r3);
}
