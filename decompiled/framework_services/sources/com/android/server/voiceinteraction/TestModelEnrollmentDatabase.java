package com.android.server.voiceinteraction;

import android.hardware.soundtrigger.SoundTrigger;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes3.dex */
public class TestModelEnrollmentDatabase implements IEnrolledModelDb {
    private final Map<EnrollmentKey, SoundTrigger.KeyphraseSoundModel> mModelMap;

    private static final class EnrollmentKey {
        private final int mKeyphraseId;
        private final String mLocale;
        private final List<Integer> mUserIds;

        EnrollmentKey(int keyphraseId, List<Integer> userIds, String locale) {
            this.mKeyphraseId = keyphraseId;
            userIds.getClass();
            this.mUserIds = userIds;
            locale.getClass();
            this.mLocale = locale;
        }

        int keyphraseId() {
            return this.mKeyphraseId;
        }

        List<Integer> userIds() {
            return this.mUserIds;
        }

        String locale() {
            return this.mLocale;
        }

        public String toString() {
            StringJoiner sj = new StringJoiner(", ", "{", "}");
            sj.add("keyphraseId: " + this.mKeyphraseId);
            sj.add("userIds: " + this.mUserIds.toString());
            sj.add("locale: " + this.mLocale.toString());
            return "EnrollmentKey: " + sj.toString();
        }

        public int hashCode() {
            int res = (1 * 31) + this.mKeyphraseId;
            return (((res * 31) + this.mUserIds.hashCode()) * 31) + this.mLocale.hashCode();
        }

        public boolean equals(Object other) {
            if (this != other) goto L6;
            return true;
        L6:
            if (other != null) goto L9;
            return false;
        L9:
            if ((other instanceof EnrollmentKey) == true) goto L11;
            return false;
        L11:
            EnrollmentKey that = (EnrollmentKey) other;
            if (this.mKeyphraseId == that.mKeyphraseId) goto L15;
            return false;
        L15:
            if (this.mUserIds.equals(that.mUserIds) == true) goto L18;
            return false;
        L18:
            if (this.mLocale.equals(that.mLocale) == true) goto L20;
            return false;
        L20:
            return true;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9ZD-qOTBtz9NCo1fdki7lW_XSFU, reason: not valid java name */
    public static /* synthetic */ boolean m9401$r8$lambda$9ZDqOTBtz9NCo1fdki7lW_XSFU(String r0, String r1, int r2, Map.Entry r3) {
        return lambda$getKeyphraseSoundModel$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ SoundTrigger.KeyphraseSoundModel $r8$lambda$AiqJ5pbZbqz9U1OXghij9Gw7Ua4(Map.Entry r0) {
        return lambda$getKeyphraseSoundModel$4(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$CBIES9RYI7oqMUyJ2eLLu5Nd468(int r0, String r1, int r2, EnrollmentKey r3) {
        return lambda$deleteKeyphraseSoundModel$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ne-CuBP7Z67n0jU4XEGMYXlD69M, reason: not valid java name */
    public static /* synthetic */ SoundTrigger.KeyphraseSoundModel m9402$r8$lambda$neCuBP7Z67n0jU4XEGMYXlD69M(Map.Entry r0) {
        return lambda$getKeyphraseSoundModel$2(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$ze5WB7eydHVmjgCOnivrbuR676M(int r0, String r1, int r2, Map.Entry r3) {
        return lambda$getKeyphraseSoundModel$1(r0, r1, r2, r3);
    }

    public TestModelEnrollmentDatabase() {
        this.mModelMap = new HashMap();
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public boolean updateKeyphraseSoundModel(SoundTrigger.KeyphraseSoundModel soundModel) {
        SoundTrigger.Keyphrase keyphrase = soundModel.getKeyphrases()[0];
        this.mModelMap.put(new EnrollmentKey(keyphrase.getId(), Arrays.stream(keyphrase.getUsers()).boxed().toList(), keyphrase.getLocale().toLanguageTag()), soundModel);
        return true;
    }

    private static /* synthetic */ boolean lambda$deleteKeyphraseSoundModel$0(int keyphraseId, String bcp47Locale, int userHandle, EnrollmentKey key) {
        if (key.keyphraseId() == keyphraseId) goto L5;
    L9:
        return false;
    L5:
        if (key.locale().equals(bcp47Locale) == false) goto L9;
        if (key.userIds().contains(Integer.valueOf(userHandle)) == false) goto L9;
        return true;
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public boolean deleteKeyphraseSoundModel(final int keyphraseId, final int userHandle, final String bcp47Locale) {
        return this.mModelMap.keySet().removeIf(new TestModelEnrollmentDatabase$$ExternalSyntheticLambda0(keyphraseId, bcp47Locale, userHandle));
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(final int keyphraseId, final int userHandle, final String bcp47Locale) {
        return (SoundTrigger.KeyphraseSoundModel) this.mModelMap.entrySet().stream().filter(new TestModelEnrollmentDatabase$$ExternalSyntheticLambda1(keyphraseId, bcp47Locale, userHandle)).findFirst().map(new TestModelEnrollmentDatabase$$ExternalSyntheticLambda2()).orElse(null);
    }

    private static /* synthetic */ boolean lambda$getKeyphraseSoundModel$1(int keyphraseId, String bcp47Locale, int userHandle, Map.Entry entry) {
        if (((EnrollmentKey) entry.getKey()).keyphraseId() == keyphraseId) goto L5;
    L9:
        return false;
    L5:
        if (((EnrollmentKey) entry.getKey()).locale().equals(bcp47Locale) == false) goto L9;
        if (((EnrollmentKey) entry.getKey()).userIds().contains(Integer.valueOf(userHandle)) == false) goto L9;
        return true;
    }

    private static /* synthetic */ SoundTrigger.KeyphraseSoundModel lambda$getKeyphraseSoundModel$2(Map.Entry entry) {
        return (SoundTrigger.KeyphraseSoundModel) entry.getValue();
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(final String keyphrase, final int userHandle, final String bcp47Locale) {
        return (SoundTrigger.KeyphraseSoundModel) this.mModelMap.entrySet().stream().filter(new TestModelEnrollmentDatabase$$ExternalSyntheticLambda3(keyphrase, bcp47Locale, userHandle)).findFirst().map(new TestModelEnrollmentDatabase$$ExternalSyntheticLambda4()).orElse(null);
    }

    private static /* synthetic */ boolean lambda$getKeyphraseSoundModel$3(String keyphrase, String bcp47Locale, int userHandle, Map.Entry entry) {
        if (((SoundTrigger.KeyphraseSoundModel) entry.getValue()).getKeyphrases()[0].getText().equals(keyphrase) == true) goto L5;
        return false;
    L5:
        if (((EnrollmentKey) entry.getKey()).locale().equals(bcp47Locale) == true) goto L7;
        return false;
    L7:
        if (((EnrollmentKey) entry.getKey()).userIds().contains(Integer.valueOf(userHandle)) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static /* synthetic */ SoundTrigger.KeyphraseSoundModel lambda$getKeyphraseSoundModel$4(Map.Entry entry) {
        return (SoundTrigger.KeyphraseSoundModel) entry.getValue();
    }

    @Override // com.android.server.voiceinteraction.IEnrolledModelDb
    public void dump(PrintWriter pw) {
        pw.println("Using test enrollment database, with enrolled models:");
        pw.println(this.mModelMap);
    }
}
