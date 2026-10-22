package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
class MediaSessionCompat$MediaSessionImplApi21$ExtraSession extends IMediaSession.Stub {
    final /* synthetic */ b this$0;

    public MediaSessionCompat$MediaSessionImplApi21$ExtraSession(b bVar) {
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i4) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void adjustVolume(int i4, int i5, String str) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void fastForward() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public Bundle getExtras() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public long getFlags() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PendingIntent getLaunchPendingIntent() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public MediaMetadataCompat getMetadata() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getPackageName() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PlaybackStateCompat getPlaybackState() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public List<MediaSessionCompat$QueueItem> getQueue() {
        return null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public CharSequence getQueueTitle() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int getRatingType() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int getRepeatMode() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int getShuffleMode() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getTag() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public ParcelableVolumeInfo getVolumeAttributes() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean isCaptioningEnabled() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean isTransportControlEnabled() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void next() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void pause() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void play() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void playFromSearch(String str, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepare() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void previous() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void rate(RatingCompat ratingCompat) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void removeQueueItemAt(int i4) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void rewind() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void seekTo(long j4) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void sendCommand(String str, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean sendMediaButton(KeyEvent keyEvent) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setCaptioningEnabled(boolean z4) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setRepeatMode(int i4) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setShuffleMode(int i4) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setShuffleModeEnabledRemoved(boolean z4) throws RemoteException {
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setVolumeTo(int i4, int i5, String str) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void skipToQueueItem(long j4) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void stop() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        throw null;
    }
}
