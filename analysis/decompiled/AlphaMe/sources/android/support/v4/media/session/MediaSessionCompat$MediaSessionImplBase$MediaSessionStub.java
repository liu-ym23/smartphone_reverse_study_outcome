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
class MediaSessionCompat$MediaSessionImplBase$MediaSessionStub extends IMediaSession.Stub {
    final /* synthetic */ d this$0;

    public MediaSessionCompat$MediaSessionImplBase$MediaSessionStub(d dVar) {
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        postToHandler(25, mediaDescriptionCompat);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i4) {
        postToHandler(26, mediaDescriptionCompat, i4);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void adjustVolume(int i4, int i5, String str) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void fastForward() throws RemoteException {
        postToHandler(16);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public Bundle getExtras() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public long getFlags() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PendingIntent getLaunchPendingIntent() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public MediaMetadataCompat getMetadata() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getPackageName() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PlaybackStateCompat getPlaybackState() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public List<MediaSessionCompat$QueueItem> getQueue() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public CharSequence getQueueTitle() {
        throw null;
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
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public ParcelableVolumeInfo getVolumeAttributes() {
        throw null;
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
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void next() throws RemoteException {
        postToHandler(14);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void pause() throws RemoteException {
        postToHandler(12);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void play() throws RemoteException {
        postToHandler(7);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
        postToHandler(8, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void playFromSearch(String str, Bundle bundle) throws RemoteException {
        postToHandler(9, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
        postToHandler(10, uri, bundle);
    }

    public void postToHandler(int i4) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepare() throws RemoteException {
        postToHandler(3);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
        postToHandler(4, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
        postToHandler(5, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
        postToHandler(6, uri, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void previous() throws RemoteException {
        postToHandler(15);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void rate(RatingCompat ratingCompat) throws RemoteException {
        postToHandler(19, ratingCompat);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        postToHandler(31, ratingCompat, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        postToHandler(27, mediaDescriptionCompat);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void removeQueueItemAt(int i4) {
        postToHandler(28, i4);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void rewind() throws RemoteException {
        postToHandler(17);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void seekTo(long j4) throws RemoteException {
        postToHandler(18, Long.valueOf(j4));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void sendCommand(String str, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        postToHandler(1, new c(str, bundle, mediaSessionCompat$ResultReceiverWrapper.f2340a));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
        postToHandler(20, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean sendMediaButton(KeyEvent keyEvent) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setCaptioningEnabled(boolean z4) throws RemoteException {
        postToHandler(29, Boolean.valueOf(z4));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setRepeatMode(int i4) throws RemoteException {
        postToHandler(23, i4);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setShuffleMode(int i4) throws RemoteException {
        postToHandler(30, i4);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setShuffleModeEnabledRemoved(boolean z4) throws RemoteException {
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void setVolumeTo(int i4, int i5, String str) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void skipToQueueItem(long j4) {
        postToHandler(11, Long.valueOf(j4));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void stop() throws RemoteException {
        postToHandler(13);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        throw null;
    }

    public void postToHandler(int i4, int i5) {
        throw null;
    }

    public void postToHandler(int i4, Object obj) {
        throw null;
    }

    public void postToHandler(int i4, Object obj, int i5) {
        throw null;
    }

    public void postToHandler(int i4, Object obj, Bundle bundle) {
        throw null;
    }
}
