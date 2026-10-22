package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: classes.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Object f5117a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static aa f5118b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f5119c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f5120d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5121e = false;

    public void b() {
        if (this.f5121e) {
            try {
                Handler handler = this.f5120d;
                if (handler != null) {
                    handler.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.f5121e) {
            try {
                Handler handler = this.f5120d;
                if (handler != null) {
                    handler.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.f5121e) {
            try {
                Handler handler = this.f5120d;
                if (handler != null) {
                    handler.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.f5121e) {
            return;
        }
        this.f5121e = true;
        if (this.f5119c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f5119c = handlerThread;
            handlerThread.start();
            if (this.f5119c != null) {
                this.f5120d = new Handler(this.f5119c.getLooper()) { // from class: com.baidu.location.b.aa.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i4 = message.what;
                        if (i4 == 1) {
                            Bundle data = message.getData();
                            try {
                                Location location = (Location) data.getParcelable("loc");
                                data.getInt("satnum");
                                if (location != null) {
                                    i.a().a(location);
                                    return;
                                }
                                return;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        if (i4 == 2) {
                            z.a(v.c(), com.baidu.location.c.f.a().r(), v.d(), v.a(), v.e());
                            return;
                        }
                        if (i4 == 3) {
                            z.a(v.c(), (com.baidu.location.c.k) null, v.d(), b.a().c(), v.e());
                            return;
                        }
                        if (i4 == 4) {
                            boolean zL = com.baidu.location.c.f.a().l();
                            if (!com.baidu.location.e.h.b() && zL) {
                                k.a().d();
                            }
                            try {
                                if (aa.this.f5120d != null) {
                                    aa.this.f5120d.sendEmptyMessageDelayed(4, com.baidu.location.e.h.f5906Q);
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            y.a().b();
                            return;
                        }
                        if (i4 == 7) {
                            z.a().c();
                            return;
                        }
                        if (i4 == 8 || i4 == 9) {
                            message.getData();
                            return;
                        }
                        if (i4 != 11) {
                            return;
                        }
                        Bundle data2 = message.getData();
                        try {
                            y.a().a((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), data2.getLong("gps_time"));
                        } catch (Exception unused) {
                        }
                    }
                };
            }
        }
        try {
            Handler handler = this.f5120d;
            if (handler != null) {
                handler.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            Handler handler2 = this.f5120d;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.h.f5906Q);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void f() {
        if (this.f5121e) {
            i.a().b();
            try {
                Handler handler = this.f5120d;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f5120d = null;
            try {
                HandlerThread handlerThread = this.f5119c;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.f5119c.interrupt();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f5119c = null;
            this.f5121e = false;
        }
    }

    public static aa a() {
        aa aaVar;
        synchronized (f5117a) {
            try {
                if (f5118b == null) {
                    f5118b = new aa();
                }
                aaVar = f5118b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aaVar;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j4) {
        if (!this.f5121e || gnssNavigationMessage == null) {
            return;
        }
        try {
            Handler handler = this.f5120d;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage(11);
                Bundle bundle = new Bundle();
                bundle.putParcelable("gnss_navigation_message", gnssNavigationMessage);
                bundle.putLong("gps_time", j4);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(Location location, int i4) {
        if (!this.f5121e || location == null) {
            return;
        }
        try {
            Handler handler = this.f5120d;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i4);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
