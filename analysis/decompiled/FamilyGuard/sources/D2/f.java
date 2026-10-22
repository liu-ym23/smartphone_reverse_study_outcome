package D2;

import android.os.AsyncTask;

/* loaded from: classes.dex */
abstract class f<K, V> extends h<K, V> {

    /* renamed from: g, reason: collision with root package name */
    private a<K, V> f1177g;

    static class a<K, V> extends AsyncTask<v<K>, Void, V> {

        /* renamed from: a, reason: collision with root package name */
        private final f<K, V> f1178a;

        a(f<K, V> fVar) {
            this.f1178a = fVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public V doInBackground(v<K>[] vVarArr) {
            return this.f1178a.e(vVarArr[0]);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(V v5) {
            super.onPostExecute(v5);
            if (isCancelled() || this.f1178a.f()) {
                return;
            }
            this.f1178a.h(v5);
        }
    }

    f() {
    }

    @Override // D2.h, D2.A
    public void a(r<K, V> rVar, v<K> vVar, z<V> zVar, u<K, V> uVar) {
        super.a(rVar, vVar, zVar, uVar);
        if (rVar instanceof e) {
            a<K, V> aVar = new a<>(this);
            this.f1177g = aVar;
            aVar.execute(vVar);
        }
    }

    @Override // D2.h, D2.A
    public void cancel() {
        super.cancel();
        this.f1177g.cancel(true);
    }

    @Override // D2.h
    protected V e(v<K> vVar) {
        return (V) super.e(vVar);
    }

    @Override // D2.h
    protected void h(V v5) {
        super.h(v5);
    }
}
